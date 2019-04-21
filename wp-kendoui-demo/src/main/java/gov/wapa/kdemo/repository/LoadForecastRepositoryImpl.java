package gov.wapa.kdemo.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import gov.wapa.kdemo.model.LoadForecast;

@Repository
public class LoadForecastRepositoryImpl implements LoadForecastRepository {

	private List<LoadForecast> data = new ArrayList<LoadForecast>();

	/*
	 * add a new loadforecast record to the datan
	 */
	@Override
	public void add(LoadForecast loadForecast) {
		if (loadForecast == null)
			return;
		if (loadForecast.getId() == 0) {
			loadForecast.setId(data.size() + 1);
		}
		data.add(loadForecast);

	}

	@Override
	public void add(List<LoadForecast> loadForecasts) {

		for (LoadForecast loadForecast : loadForecasts) {
			this.add(loadForecast);
		}
	}

	@Override
	public void delete(long id) {
		LoadForecast target = data.stream().filter(temp -> temp.getId() == id).findFirst().get();
		if (target != null) {
			data.remove(target);
		}

	}

	@Override
	public LoadForecast get(long id) {
		LoadForecast target = data.stream().filter(temp -> temp.getId() == id).findFirst().get();
		return target;
	}
	
	@Override
	public List<LoadForecast> getList() {
		return data;
	}

	@Override
	public List<LoadForecast> getList(Date startDate) {

		List<LoadForecast> targets = data.stream().filter(temp -> temp.getStartDate() == startDate).sorted()
				.collect(Collectors.toList());
		return targets;
	}

	@Override
	public List<LoadForecast> getList(Date startDate, Date endDate) {

		List<LoadForecast> targets = data.stream().filter(temp -> temp.getStartDate().getTime() >= startDate.getTime()
				|| temp.getEndDate().getTime() <= endDate.getTime()).sorted().collect(Collectors.toList());
		return targets;
	}

	/**
	 * 
	 */
	@PostConstruct
	public void initialize() {

		long RECORD_TYPE = 255;
		long UNIT_OF_MEASURE = 1;
		int MINUTE_INTERVAL = 15;
		for (int i = 1; i <= 200; i++) {
			data.add(new LoadForecast(i, RECORD_TYPE, UNIT_OF_MEASURE, MINUTE_INTERVAL, "Load Forecast -> "+i,
					"Load forecast. Record type: "+ RECORD_TYPE+". Id: "+ i, "test data for load forecast "+ i, new Date(), new Date()));
		}
	}

}
