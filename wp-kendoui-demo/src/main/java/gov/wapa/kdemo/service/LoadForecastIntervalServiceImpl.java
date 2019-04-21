package gov.wapa.kdemo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.wapa.kdemo.model.LoadForecastInterval;
import gov.wapa.kdemo.repository.LoadForecastIntervalRepository;

@Service
public class LoadForecastIntervalServiceImpl implements LoadForecastIntervalService {

	@Autowired
	private LoadForecastIntervalRepository loadForecastIntervalRepository;

	/*
	 * add a new loadforecast record to the data
	 */
	@Override
	public void add(LoadForecastInterval loadForecastInterval) {

		loadForecastIntervalRepository.add(loadForecastInterval);

	}

	@Override
	public void add(List<LoadForecastInterval> loadForecastIntervals) {

		loadForecastIntervalRepository.add(loadForecastIntervals);
	}

	@Override
	public void delete(long id) {
		loadForecastIntervalRepository.delete(id);

	}

	@Override
	public LoadForecastInterval get(long id) {

		return loadForecastIntervalRepository.get(id);
	}
	
	
	@Override
	public List<LoadForecastInterval> getList() {

		return loadForecastIntervalRepository.getList();
	}
	@Override
	public List<LoadForecastInterval> getList(Date startDate) {

		return loadForecastIntervalRepository.getList(startDate);
	}

	@Override
	public List<LoadForecastInterval> getList(Date startDate, Date endDate) {

		return loadForecastIntervalRepository.getList(startDate, endDate);
	}
}
