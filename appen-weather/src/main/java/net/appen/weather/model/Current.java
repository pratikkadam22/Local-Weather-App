package net.appen.weather.model;

public class Current {
	private double curr_time;
	private double temp;
	private double feels_like;
	
	public Current() {
		
	}
	
	public Current(double curr_time, double temp, double feels_like) {
		super();
		this.curr_time = curr_time;
		this.temp = temp;
		this.feels_like = feels_like;
	}

	public double getCurr_time() {
		return curr_time;
	}

	public void setCurr_time(double d) {
		this.curr_time = d;
	}

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	public double getFeels_like() {
		return feels_like;
	}

	public void setFeels_like(double feels_like) {
		this.feels_like = feels_like;
	}
	
	
}
