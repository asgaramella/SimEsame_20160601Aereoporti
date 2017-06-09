package it.polito.tdp.flight.model;

public class AirportAndDistance implements Comparable<AirportAndDistance>{
	
	private Airport airport;
	private double distance;
	
	public AirportAndDistance(Airport airport, double distance) {
		super();
		this.airport = airport;
		this.distance = distance;
	}
	
	public Airport getAirport() {
		return airport;
	}
	
	public void setAirport(Airport airport) {
		this.airport = airport;
	}
	
	public double getDistance() {
		return distance;
	}
	
	public void setDistance(double distance) {
		this.distance = distance;
	}

	@Override
	public int compareTo(AirportAndDistance other) {
		
		return Double.compare(this.getDistance(), other.getDistance());
	}
	
	
	

}
