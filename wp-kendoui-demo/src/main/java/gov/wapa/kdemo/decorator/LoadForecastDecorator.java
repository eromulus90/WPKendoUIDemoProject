package gov.wapa.kdemo.decorator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import gov.wapa.kdemo.model.LoadForecast;
import gov.wapa.kdemo.model.LoadForecastInterval;

public class LoadForecastDecorator {

	private LoadForecast loadForecast;
	private List<LoadForecastInterval> intervals;
	private List<BigDecimal> hourlyAverage;

	/**
	 * constructor - empty
	 */
	public LoadForecastDecorator() {

	}

	/**
	 * constructor - loadforecast and intervals
	 * 
	 * @param loadForecast
	 * @param intervals
	 */
	public LoadForecastDecorator(LoadForecast loadForecast, List<LoadForecastInterval> intervals) {
		this.loadForecast = loadForecast;
		this.intervals = intervals;

	}

	/**
	 * 
	 * @return
	 */
	public LoadForecast getLoadForecast() {
		return loadForecast;
	}

	public void setLoadForecast(LoadForecast loadForecast) {
		this.loadForecast = loadForecast;
	}

	/**
	 * 
	 * @return
	 */
	public List<LoadForecastInterval> getIntervals() {
		return intervals;
	}

	public void setIntervals(List<LoadForecastInterval> intervals) {
		this.intervals = intervals;
	}

	/**
	 * based on the minute intervals get the hourly average
	 * 
	 * @return
	 */
	public List<BigDecimal> getHourlyAverage() {
		if (hourlyAverage == null)
			hourlyAverage = new ArrayList<BigDecimal>();
		int minuteInterval = loadForecast.getMinuteInterval();

		if (minuteInterval == 0 || intervals == null || intervals.size() == 0)
			return hourlyAverage;
		/*
		 * 
		 */
		BigDecimal total = new BigDecimal("0");
		BigDecimal average = new BigDecimal("0");
		Integer intervalsPerHour = 60 / minuteInterval;
		for (int i = 0; i < intervals.size(); i++) {
			LoadForecastInterval interval = intervals.get(i);
			total = total.add(interval.getValue());
			if (i == 0 || i % intervalsPerHour == 0) {
				average = total.divide(new BigDecimal(intervalsPerHour));
				hourlyAverage.add(average);
				total = new BigDecimal("0");
			}
		}

		return hourlyAverage;
	}

	public void setHourlyAverage(List<BigDecimal> hourlyAverage) {
		this.hourlyAverage = hourlyAverage;
	}
}
