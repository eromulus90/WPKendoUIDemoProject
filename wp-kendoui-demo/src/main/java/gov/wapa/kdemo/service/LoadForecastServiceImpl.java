package gov.wapa.kdemo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.wapa.kdemo.model.LoadForecast;
import gov.wapa.kdemo.repository.LoadForecastRepository;

@Service
public class LoadForecastServiceImpl implements LoadForecastService {

	@Autowired
	private LoadForecastRepository loadForecastRepository;

	@Override
	public void add(LoadForecast loadForecast) {
		loadForecastRepository.add(loadForecast);
	}

	@Override
	public void add(List<LoadForecast> loadForecasts) {

		loadForecastRepository.add(loadForecasts);
	}

	@Override
	public void delete(long id) {
		loadForecastRepository.delete(id);
	}

	@Override
	public LoadForecast get(long id) {
		return loadForecastRepository.get(id);
	}

	@Override
	public List<LoadForecast> getList() {

		return loadForecastRepository.getList();
	}
	
	@Override
	public List<LoadForecast> getList(Date startDate) {

		return loadForecastRepository.getList(startDate);
	}

	@Override
	public List<LoadForecast> getList(Date startDate, Date endDate) {

		return loadForecastRepository.getList(startDate, endDate);
	}

}
