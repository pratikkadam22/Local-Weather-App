package net.appen.weather.services;

import org.json.JSONObject;

import net.appen.weather.model.Current;

/**
 * A class that parses the JSON object of current day's weather details
 * @author PRATIK
 *
 */
public class ParseCurrent {

	ParseWeatherDescription weatherDescription = new ParseWeatherDescription();
	public ParseCurrent() {
		
	}
	
	/**
	 * Parses the JSON object of the current day's weather details
	 * @param jsonWeather a JSON object containing weather details of current day
	 * @return a Current object of current day's weather details
	 */
	public Current parseData(JSONObject jsonWeather) {
		Current currentWeather = new Current();
		
		currentWeather.setCurr_time(jsonWeather.getDouble("dt"));
		currentWeather.setFeels_like(jsonWeather.getDouble("feels_like"));
		currentWeather.setTemp(jsonWeather.getDouble("temp"));
		currentWeather.setWeatherDescription(weatherDescription.parseData(jsonWeather.getJSONArray("weather")));
		return currentWeather;
	}

}
