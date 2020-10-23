package net.appen.weather.model;

/**
 * A class representing the weather description in words
 * @author PRATIK
 *
 */
public class WeatherDescription {
	private int id;
	private String main;
	private String description;
	
	public WeatherDescription() {
		
	}
	
	/**
	 * Creates the object of the weather description with specified details
	 * @param id A number representing the id of the weather condition
	 * @param main A string representing the group of weather parameters
	 * @param description A string representing the specific weather condition
	 */
	public WeatherDescription(int id, String main, String description) {
		super();
		this.id = id;
		this.main = main;
		this.description = description;
	}
	
	/**
	 * Gets the id of the weather condition
	 * @return A number representing the id of the weather condition
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the id of the weather condition
	 * @param id A number representing the id of the weather condition
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Gets the group of weather parameters
	 * @return A string representing the group of weather parameters
	 */
	public String getMain() {
		return main;
	}
	
	/**
	 * Sets the group of weather parameters
	 * @param main A string representing the group of weather parameters
	 */
	public void setMain(String main) {
		this.main = main;
	}
	
	/**
	 * Gets the the specific weather condition
	 * @return A string representing the specific weather condition
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Sets the specific weather condition
	 * @param description A string representing the specific weather condition
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
}
