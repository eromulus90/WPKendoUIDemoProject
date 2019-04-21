package gov.wapa.kdemo.controller.api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.wapa.kdemo.decorator.LoadForecastDecorator;
import gov.wapa.kdemo.model.LoadForecast;
import gov.wapa.kdemo.model.LoadForecastInterval;
import gov.wapa.kdemo.service.LoadForecastIntervalService;
import gov.wapa.kdemo.service.LoadForecastService;

@RequestMapping("/api/loadforecast")
@RestController
public class LoadForecastRestController {

	@Autowired
	private LoadForecastService loadForecastService;
	@Autowired
	private LoadForecastIntervalService loadForecastIntervalService;

	/**
	 * get navigation tabs
	 * 
	 * @return
	 */
	@RequestMapping("/get-loadforecasts")
	public List<LoadForecastDecorator> getLoadForecasts() {

		List<LoadForecast> loadForecasts = loadForecastService.getList();
		List<LoadForecastDecorator> decorators = new ArrayList<LoadForecastDecorator>();

		for (LoadForecast forecast : loadForecasts) {
			List<LoadForecastInterval> intervals = getIntervals(forecast.getId());
			LoadForecastDecorator decorator = new LoadForecastDecorator(forecast, intervals);
			decorators.add(decorator);
		}

		return decorators;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	private List<LoadForecastInterval> getIntervals(long id) {
		List<LoadForecastInterval> intervals = loadForecastIntervalService.getList();
		List<LoadForecastInterval> targets = intervals.stream().filter(temp -> temp.getLoadForecastId() == id)
				.collect(Collectors.toList());

		return targets;
	}

}
