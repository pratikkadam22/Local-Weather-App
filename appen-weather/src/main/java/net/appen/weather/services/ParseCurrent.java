package net.appen.weather.services;

import org.json.JSONObject;

import net.appen.weather.model.Current;

public class ParseCurrent {

	ParseWeatherDescription weatherDescription = new ParseWeatherDescription();
	public ParseCurrent() {
		
	}
	
	public Current parseData(JSONObject jsonWeather) {
		Current currentWeather = new Current();
		
		currentWeather.setCurr_time(jsonWeather.getDouble("dt"));
		currentWeather.setFeels_like(jsonWeather.getDouble("feels_like"));
		currentWeather.setTemp(jsonWeather.getDouble("temp"));
		currentWeather.setWeatherDescription(weatherDescription.parseData(jsonWeather.getJSONArray("weather")));
		return currentWeather;
	}

}
