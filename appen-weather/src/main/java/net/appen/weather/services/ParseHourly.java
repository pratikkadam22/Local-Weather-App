package net.appen.weather.services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import net.appen.weather.model.Hourly;

/**
 * A class that parses the hourly data
 * @author PRATIK
 *
 */
public class ParseHourly {
	
	public ParseHourly() {
		
	}
	
	/**
	 * Return a list of weather details of specific set of hours.
	 * Example:- if offset='start' and hrs='4', then we only parse the first 4 hours from the list.
	 * if offset='end' and hrs='4', then we only parse the last 4 hours from the list.
	 * @param jsonArray a JSON array containing weather details of multiple hours
	 * @param offset it indicates the starting or ending set of hours
	 * @param hrs the number of hours to parse
	 * @return a list of weather details for the required hours
	 */
	public List<Hourly> parseData(JSONArray jsonArray, String offset, Integer hrs) {
		List<Hourly> hourlyData = new ArrayList<Hourly>();
		if (offset.equals("start")) {
			for(int i = 0; i < hrs; i++) {
				JSONObject hourlyJson = jsonArray.getJSONObject(i);
				Hourly hourly = new Hourly();
				hourly.setTemp(hourlyJson.getDouble("temp"));
				hourly.setTimeHour(hourlyJson.getDouble("dt"));
				hourlyData.add(hourly);
			}
		}
		else {
			for(int i = jsonArray.length() - hrs; i < jsonArray.length(); i++) {
				JSONObject hourlyJson = jsonArray.getJSONObject(i);
				Hourly hourly = new Hourly();
				hourly.setTemp(hourlyJson.getDouble("temp"));
				hourly.setTimeHour(hourlyJson.getDouble("dt"));
				hourlyData.add(hourly);
			}
		}
		return hourlyData;
	}

}
