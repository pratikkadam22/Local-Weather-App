package net.appen.weather.model;

import java.util.List;

/**
 * A class representing the weather details of Current day
 * @author PRATIK
 *
 */
public class Current {
	private double curr_time;
	private double temp;
	private double feels_like;
	private List<WeatherDescription> weatherDescription;

	public Current() {
		
	}
	
	/**
	 * Creates the Current object with the specified details of the current weather
	 * @param curr_time A number representing the current time
	 * @param temp A number representing the current temperature
	 * @param feels_like A number representing the temperature that is felt currently
	 * @param weatherDescription The description of weather
	 */
	public Current(double curr_time, double temp, double feels_like, List<WeatherDescription> weatherDescription) {
		super();
		this.curr_time = curr_time;
		this.temp = temp;
		this.feels_like = feels_like;
		this.weatherDescription = weatherDescription;
	}

	/**
	 * Gets current weather description
	 * @return A list containing single element, which describe the current weather
	 */
	public List<WeatherDescription> getWeatherDescription() {
		return weatherDescription;
	}
	
	/**
	 * Sets current weather description
	 * @param weatherDescription The description of weather
	 */
	public void setWeatherDescription(List<WeatherDescription> weatherDescription) {
		this.weatherDescription = weatherDescription;
	}
	
	/**
	 * Gets the current time
	 * @return A number representing the current time
	 */
	public double getCurr_time() {
		return curr_time;
	}

	/**
	 * Sets the current time
	 * @param A number representing the current time
	 */
	public void setCurr_time(double d) {
		this.curr_time = d;
	}

	/**
	 * Gets the current temperature
	 * @return A number representing the current temperature
	 */
	public double getTemp() {
		return temp;
	}

	/**
	 * Sets the current temperature
	 * @param A number representing the current temperature
	 */
	public void setTemp(double temp) {
		this.temp = temp;
	}

	/**
	 * Gets the temperature that is felt currently
	 * @return A number representing the temperature that is felt currently
	 */
	public double getFeels_like() {
		return feels_like;
	}

	/**
	 * Sets the temperature that is felt currently 
	 * @param A number representing the temperature that is felt currently
	 */
	public void setFeels_like(double feels_like) {
		this.feels_like = feels_like;
	}
	
	
}
