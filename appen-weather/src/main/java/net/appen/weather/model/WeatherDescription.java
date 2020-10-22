package net.appen.weather.model;

public class WeatherDescription {
	private int id;
	private String main;
	private String description;
	
	public WeatherDescription() {
		
	}
	
	public WeatherDescription(int id, String main, String description) {
		super();
		this.id = id;
		this.main = main;
		this.description = description;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMain() {
		return main;
	}
	public void setMain(String main) {
		this.main = main;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
