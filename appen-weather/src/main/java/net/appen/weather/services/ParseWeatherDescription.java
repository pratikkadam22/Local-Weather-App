package net.appen.weather.services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import net.appen.weather.model.WeatherDescription;

public class ParseWeatherDescription {
	
	public ParseWeatherDescription() {
		
	}
	
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
