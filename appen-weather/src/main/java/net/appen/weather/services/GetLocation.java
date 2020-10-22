package net.appen.weather.services;

import java.util.ArrayList;
import java.util.List;
//import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import net.appen.weather.repository.DayWeather;

@Service
public class GetLocation {
	
	GetRawJSON getRaw = new GetRawJSON();
	ParseCurrent parseCurrent = new ParseCurrent();
	ParseHourly parseHourly = new ParseHourly();
	
	String api_key = "70aba059b24d4f197e47d139d93b75c4";
	public GetLocation() {
		
	}
	
	public Integer PreProcessTime(Integer epochtime) {
		return 0;
	}
	
	public DayWeather getDayWeather(String latitude, String longitude, String epochtime, String unit) throws Exception {
		DayWeather day = new DayWeather();
		String url = "http://api.openweathermap.org/data/2.5/onecall/timemachine?"
				+ "lat=" + latitude
				+ "&lon=" + longitude
				+ "&dt=" + epochtime
				+ "&units=" + unit
				+ "&appid=" + api_key;
		System.out.println(url);
		String rawJson = getRaw.request(url);
		JSONObject root = new JSONObject(rawJson);
		
		day.setLatitude(root.getDouble("lat"));
		day.setLongitude(root.getDouble("lon"));
		day.setTimezone(root.getString("timezone"));
		day.setUnit(unit);
		day.setCurrent(parseCurrent.parseData(root.getJSONObject("current")));
		day.setHourly(parseHourly.parseData(root.getJSONArray("hourly")));
		
	    return day;
	}
	
	public List<DayWeather> getWeather(Map<String, String> coords) throws Exception{
		List<DayWeather> weatherData = new ArrayList<DayWeather>();
		DayWeather metricData, imperialData;
		String latitude = coords.get("latitude").toString();
		String longitude = coords.get("longitude").toString();
		String time = coords.get("time").toString();
		metricData = getDayWeather(latitude, longitude, time, "metric");
		imperialData = getDayWeather(latitude, longitude, time, "imperial");
		weatherData.add(metricData);
		weatherData.add(imperialData);
		return weatherData;
	}
}
