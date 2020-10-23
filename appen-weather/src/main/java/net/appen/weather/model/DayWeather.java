package net.appen.weather.model;

import java.util.List;

/**
 * A class representing the weather data of current day
 * @author PRATIK
 *
 */
public class DayWeather {
	private double latitude;
	private double longitude;
	private String timezone;
	private String unit;
	private Current current;
	private List<Hourly> hourly;
	
	public DayWeather() {
		
	}
	
	/**
	 * Creates the DayWeather object with specified data of current day 
	 * @param latitude The latitude coordinates for current location
	 * @param longitude The longitude coordinates for current location
	 * @param timezone The timezone of current location
	 * @param unit The required unit of details(metric or imperial)
	 * @param current The current day's weather details
	 * @param hourly The list of data for all the hours of particular day
	 */
	public DayWeather(double latitude, double longitude, String timezone, String unit, Current current, List<Hourly> hourly) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.timezone = timezone;
		this.unit = unit;
		this.current = current;
		this.hourly = hourly;
	}
	
	/**
	 * Gets the current day's weather details
	 * @return The object representing current day's weather details
	 */
	public Current getCurrent() {
		return current;
	}
	
	/**
	 * Sets the current day's weather details
	 * @param current The object representing current day's weather details
	 */
	public void setCurrent(Current current) {
		this.current = current;
	}
	
	/**
	 * Gets the unit of details(metric or imperial)
	 * @return A string representing the unit of details(metric or imperial)
	 */
	public String getUnit() {
		return unit;
	}
	
	/**
	 * Sets the unit of details(metric or imperial)
	 * @param unit A string representing the unit of details(metric or imperial)
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	/**
	 * Gets the latitude coordinates for current location
	 * @return A number representing the latitude coordinates for current location
	 */
	public double getLatitude() {
		return latitude;
	}
	
	/**
	 * Sets the latitude coordinates for current location
	 * @param latitude A number representing the latitude coordinates for current location
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	/**
	 * Gets the longitude coordinates for current location
	 * @return A number representing the longitude coordinates for current location
	 */
	public double getLongitude() {
		return longitude;
	}
	
	/**
	 * Sets the longitude coordinates for current location
	 * @param longitude A number representing the longitude coordinates for current location
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	/**
	 * Gets the timezone of current location
	 * @return A string representing the timezone of current location
	 */
	public String getTimezone() {
		return timezone;
	}
	
	/**
	 * Sets the timezone of current location
	 * @param timezone A string representing the timezone of current location
	 */
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	
	/**
	 * Gets the list of data for all the hours of particular day
	 * @return The list of data for all the hours of particular day
	 */
	public List<Hourly> getHourly() {
		return hourly;
	}
	
	/**
	 * Sets the list of data for all the hours of particular day
	 * @param list The list of data for all the hours of particular day
	 */
	public void setHourly(List<Hourly> list) {
		this.hourly = list;
	}
}
