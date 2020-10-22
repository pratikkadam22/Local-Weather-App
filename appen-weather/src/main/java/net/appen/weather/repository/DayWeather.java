package net.appen.weather.repository;

import java.util.List;

public class DayWeather {
	private double latitude;
	private double longitude;
	private String timezone;
	private String unit;
	private Current current;
	private List<Hourly> hourly;
	
	public DayWeather() {
		
	}
	
	public DayWeather(double latitude, double longitude, String timezone, String unit, Current current, List<Hourly> hourly) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.timezone = timezone;
		this.unit = unit;
		this.current = current;
		this.hourly = hourly;
	}
	
	public Current getCurrent() {
		return current;
	}
	public void setCurrent(Current current) {
		this.current = current;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double d) {
		this.longitude = d;
	}
	public String getTimezone() {
		return timezone;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	public List<Hourly> getHourly() {
		return hourly;
	}
	public void setHourly(List<Hourly> list) {
		this.hourly = list;
	}
}
