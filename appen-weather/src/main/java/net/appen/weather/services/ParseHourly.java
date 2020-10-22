package net.appen.weather.services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import net.appen.weather.repository.Hourly;

public class ParseHourly {
	
	public ParseHourly() {
		
	}

	public List<Hourly> parseData(JSONArray jsonArray) {
		List<Hourly> hourlyData = new ArrayList<Hourly>();
		for(int i = 0; i < jsonArray.length(); i++) {
			JSONObject hourlyJson = jsonArray.getJSONObject(i);
			Hourly hourly = new Hourly();
			hourly.setTemp(hourlyJson.getDouble("temp"));
			hourly.setTimeHour(hourlyJson.getDouble("dt"));
			hourlyData.add(hourly);
		}
		return hourlyData;
	}

}
