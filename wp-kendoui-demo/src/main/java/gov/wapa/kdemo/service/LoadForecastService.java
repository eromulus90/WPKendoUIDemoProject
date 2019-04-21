package gov.wapa.kdemo.service;

import java.util.Date;
import java.util.List;

import gov.wapa.kdemo.model.LoadForecast;

public interface LoadForecastService {
		
	public void add(LoadForecast loadForecast);
	public void add(List<LoadForecast> loadForecasts);
	
	public void delete(long id);
	
	public LoadForecast get(long id);
	public List<LoadForecast> getList();
	public List<LoadForecast> getList(Date startDate);
	public List<LoadForecast> getList(Date startDate, Date endDate);

}
