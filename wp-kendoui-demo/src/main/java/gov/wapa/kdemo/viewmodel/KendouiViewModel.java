package gov.wapa.kdemo.viewmodel;

import java.util.List;

import gov.wapa.kdemo.model.LoadForecast;

public class KendouiViewModel {

	private List<LoadForecast> loadForecasts;

	public KendouiViewModel(List<LoadForecast> loadForecasts) {
		this.loadForecasts = loadForecasts;
	}

	public List<LoadForecast> getLoadForecasts() {
		return loadForecasts;
	}

	public void setLoadForecasts(List<LoadForecast> loadForecasts) {
		this.loadForecasts = loadForecasts;
	}
}


