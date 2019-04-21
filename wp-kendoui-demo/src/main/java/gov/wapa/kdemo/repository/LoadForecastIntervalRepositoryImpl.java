package gov.wapa.kdemo.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import gov.wapa.kdemo.model.LoadForecastInterval;

@Repository
public class LoadForecastIntervalRepositoryImpl implements LoadForecastIntervalRepository {

	private List<LoadForecastInterval> data = new ArrayList<LoadForecastInterval>();

	/*
	 * add a new loadforecast record to the data
	 */
	@Override
	public void add(LoadForecastInterval loadForecastInterval) {
		if (loadForecastInterval == null)
			return;
		if (loadForecastInterval.getId() == 0) {
			loadForecastInterval.setId(data.size() + 1);
		}
		data.add(loadForecastInterval);

	}

	@Override
	public void add(List<LoadForecastInterval> loadForecastIntervals) {

		for (LoadForecastInterval loadForecastInterval : loadForecastIntervals) {
			this.add(loadForecastInterval);
		}
	}

	@Override
	public void delete(long id) {
		LoadForecastInterval target = data.stream().filter(temp -> temp.getId() == id).findFirst().get();
		if (target != null) {
			data.remove(target);
		}

	}

	@Override
	public LoadForecastInterval get(long id) {
		LoadForecastInterval target = data.stream().filter(temp -> temp.getId() == id).findFirst().get();
		return target;
	}
	@Override
	public List<LoadForecastInterval> getList() {

		return data;
	}
	
	@Override
	public List<LoadForecastInterval> getList(Date startDate) {

		List<LoadForecastInterval> targets = data.stream().filter(temp -> temp.getStartDate() == startDate).sorted()
				.collect(Collectors.toList());
		return targets;
	}

	@Override
	public List<LoadForecastInterval> getList(Date startDate, Date endDate) {

		List<LoadForecastInterval> targets = data.stream()
				.filter(temp -> temp.getStartDate().getTime() >= startDate.getTime()
						|| temp.getEndDate().getTime() <= endDate.getTime())
				.sorted().collect(Collectors.toList());
		return targets;
	}

	/**
	 * 
	 */
	@PostConstruct
	public void initialize() {

		Random random = new Random();
		long loadForecastId = 1;
		for (int i = 1; i <= 10000; i++) {
			data.add(new LoadForecastInterval(i, loadForecastId, new Date(), new Date(),
					new BigDecimal(random.nextInt(200))));
			if (i>=96 && i % 96 == 0)
				loadForecastId++;
		}
	}
}
