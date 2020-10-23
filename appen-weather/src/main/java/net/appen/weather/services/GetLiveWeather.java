package net.appen.weather.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
//import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import net.appen.weather.model.DayWeather;
import net.appen.weather.model.Hourly;

/**
 * A class that parses the input JSON request and returns the requested weather data
 * @author PRATIK
 *
 */
@Service
public class GetLiveWeather {
	
	GetRawJSON getRaw = new GetRawJSON();
	ParseCurrent parseCurrent = new ParseCurrent();
	ParseHourly parseHourly = new ParseHourly();
	
	String api_key = "70aba059b24d4f197e47d139d93b75c4";
	public GetLiveWeather() {
		
	}
	
	/**
	 * This function extracts the weather data for one particular day
	 * @param latitude The latitude coordinates for current location
	 * @param longitude The longitude coordinates for current location
	 * @param epochtime The current time
	 * @param unit The required unit of details(metric or imperial)
	 * @param flag Tt is used to determine the index of the day(0 for current day)
	 * @return Weather for a particular day
	 */
	public DayWeather getDayWeather(String latitude, String longitude, String epochtime, String unit, Integer flag) throws Exception {
		DayWeather day = new DayWeather();
		Date exp = new Date(Long.parseLong(epochtime)*1000);
		Calendar cal = Calendar.getInstance();
		cal.setTime(exp);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		JSONObject root;
		if(hour >= 17) {
			List<Hourly> hourlyDataCurr = new ArrayList<Hourly>();
			List<Hourly> hourlyDataPrev = new ArrayList<Hourly>();
			String url = "http://api.openweathermap.org/data/2.5/onecall/timemachine?"
					+ "lat=" + latitude
					+ "&lon=" + longitude
					+ "&dt=" + epochtime
					+ "&units=" + unit
					+ "&appid=" + api_key;
			String rawJson = getRaw.request(url);
			root = new JSONObject(rawJson);
			day.setLatitude(root.getDouble("lat"));
			day.setLongitude(root.getDouble("lon"));
			day.setTimezone(root.getString("timezone"));
			day.setUnit(unit);
			day.setCurrent(parseCurrent.parseData(root.getJSONObject("current")));
			Integer start = 7;
			if(flag == 0) {
				start = hour - 17 + 1;
			}
			hourlyDataCurr = parseHourly.parseData(root.getJSONArray("hourly"), "start", start);
			
			long epoch = Long.parseLong(epochtime);
			String newEpoch = String.valueOf(epoch - 86400);
			String url2 = "http://api.openweathermap.org/data/2.5/onecall/timemachine?"
					+ "lat=" + latitude
					+ "&lon=" + longitude
					+ "&dt=" + newEpoch
					+ "&units=" + unit
					+ "&appid=" + api_key;
			String rawJson2 = getRaw.request(url2);
			root = new JSONObject(rawJson2);
			hourlyDataPrev = parseHourly.parseData(root.getJSONArray("hourly"), "end", 17);
			
			hourlyDataPrev.addAll(hourlyDataCurr);
			day.setHourly(hourlyDataPrev);
		}
		else {
			List<Hourly> hourlyDataCurr = new ArrayList<Hourly>();
			List<Hourly> hourlyDataPrev = new ArrayList<Hourly>();
			String url = "http://api.openweathermap.org/data/2.5/onecall/timemachine?"
					+ "lat=" + latitude
					+ "&lon=" + longitude
					+ "&dt=" + epochtime
					+ "&units=" + unit
					+ "&appid=" + api_key;
			String rawJson = getRaw.request(url);
			root = new JSONObject(rawJson);
			day.setLatitude(root.getDouble("lat"));
			day.setLongitude(root.getDouble("lon"));
			day.setTimezone(root.getString("timezone"));
			day.setUnit(unit);
			day.setCurrent(parseCurrent.parseData(root.getJSONObject("current")));
			Integer start = 17;
			if(flag == 0) {
				start = hour + 1;
				hourlyDataCurr = parseHourly.parseData(root.getJSONArray("hourly"), "end", start);
				day.setHourly(hourlyDataCurr);
				return day;
			}
			hourlyDataCurr = parseHourly.parseData(root.getJSONArray("hourly"), "end", start);
			long epoch = Long.parseLong(epochtime);
			String newEpoch = String.valueOf(epoch + 86400);
			String url2 = "http://api.openweathermap.org/data/2.5/onecall/timemachine?"
					+ "lat=" + latitude
					+ "&lon=" + longitude
					+ "&dt=" + newEpoch
					+ "&units=" + unit
					+ "&appid=" + api_key;
			String rawJson2 = getRaw.request(url2);
			root = new JSONObject(rawJson2);
			hourlyDataPrev = parseHourly.parseData(root.getJSONArray("hourly"), "start", 7);
			
			hourlyDataCurr.addAll(hourlyDataPrev);
			day.setHourly(hourlyDataCurr);
		}		
	    return day;
	}
	
	/**
	 * Returns a list of weather data for the 4 recent days.
	 * @param coords a map containing the inputs like latitude, longitude and time from the front end
	 * @return a list of weather data
	 */
	public List<List<DayWeather>> getWeather(Map<String, String> coords) throws Exception{
		List<List<DayWeather>> weatherWeek = new ArrayList<List<DayWeather>>();
		String latitude = coords.get("latitude").toString();
		String longitude = coords.get("longitude").toString();
		
		for(int i = 0; i < 4; i++) {
			List<DayWeather> weatherData = new ArrayList<DayWeather>();
			DayWeather metricData, imperialData;
			Long time = Long.parseLong(coords.get("time"));
//			Long time = Long.parseLong("1603322344");
			String timeStr = String.valueOf(time - (86400 * i));
			metricData = getDayWeather(latitude, longitude, timeStr, "metric", i);
			imperialData = getDayWeather(latitude, longitude, timeStr, "imperial", i);
			weatherData.add(metricData);
			weatherData.add(imperialData);
			weatherWeek.add(weatherData);
		}
		return weatherWeek;
	}
}
