package net.appen.weather.services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import net.appen.weather.model.WeatherDescription;

/**
 * A class that parses the Weather description in words
 * @author PRATIK
 *
 */
public class ParseWeatherDescription {
	
	public ParseWeatherDescription() {
		
	}
	
	/**
	 * Parses the description of weather of a particular day
	 * @param jsonArray a JSON array containing just one element, which contain weather description of a day
	 * @return weather description of a day
	 */
	public List<WeatherDescription> parseData(JSONArray jsonArray) {
		List<WeatherDescription> weatherData = new ArrayList<WeatherDescription>();
		for(int i = 0; i < jsonArray.length(); i++) {
			JSONObject weatherJson = jsonArray.getJSONObject(i);
			WeatherDescription weather = new WeatherDescription();
			weather.setId(weatherJson.getInt("id"));
			weather.setMain(weatherJson.getString("main"));
			weather.setDescription(weatherJson.getString("description"));
			weatherData.add(weather);
		}
		return weatherData;
	}
}
