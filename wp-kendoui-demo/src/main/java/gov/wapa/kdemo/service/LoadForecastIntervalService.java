package gov.wapa.kdemo.service;

import java.util.Date;
import java.util.List;

import gov.wapa.kdemo.model.LoadForecastInterval;

public interface LoadForecastIntervalService {

	public void add(LoadForecastInterval loadForecastInterval);

	public void add(List<LoadForecastInterval> loadForecastIntervals);

	public void delete(long id);

	public LoadForecastInterval get(long id);

	public List<LoadForecastInterval> getList();
	public List<LoadForecastInterval> getList(Date startDate);

	public List<LoadForecastInterval> getList(Date startDate, Date endDate);
}
