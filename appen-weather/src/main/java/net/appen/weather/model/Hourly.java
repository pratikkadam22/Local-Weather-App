package net.appen.weather.model;

/**
 * A class representing the temperature of a specific hour
 * @author PRATIK
 *
 */
public class Hourly {
	private double timeHour;
	private double temp;
	
	public Hourly() {
		
	}
	
	/**
	 * Gets the starting time of hour
	 * @return A number representing the starting time of hour
	 */
	public double getTimeHour() {
		return timeHour;
	}

	/**
	 * Sets the starting time of hour
	 * @param timeHour A number representing the starting time of hour
	 */
	public void setTimeHour(double timeHour) {
		this.timeHour = timeHour;
	}

	/**
	 * Gets the temperature at starting time of hour
	 * @return A number representing the temperature at starting time of hour
	 */
	public double getTemp() {
		return temp;
	}

	/**
	 * Sets the temperature at starting time of hour
	 * @param temp A number representing the temperature at starting time of hour
	 */
	public void setTemp(double temp) {
		this.temp = temp;
	}

	/**
	 * Creates the object of Hour with specified details
	 * @param timeHour A number representing the starting time of hour
	 * @param temp A number representing the temperature at starting time of hour
	 */
	public Hourly(double timeHour, double temp) {
		super();
		this.timeHour = timeHour;
		this.temp = temp;
	}
	
}
