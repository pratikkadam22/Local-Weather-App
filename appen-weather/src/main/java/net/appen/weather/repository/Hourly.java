package net.appen.weather.repository;

public class Hourly {
	private double timeHour;
	private double temp;
	
	public Hourly() {
		
	}
	
	public double getTimeHour() {
		return timeHour;
	}

	public void setTimeHour(double timeHour) {
		this.timeHour = timeHour;
	}

	public double getTemp() {
		return temp;
	}

	public void setTemp(double d) {
		this.temp = d;
	}

	public Hourly(double timeHour, double temp) {
		super();
		this.timeHour = timeHour;
		this.temp = temp;
	}
	
}
