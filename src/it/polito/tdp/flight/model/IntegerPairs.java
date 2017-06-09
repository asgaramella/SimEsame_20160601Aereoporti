package it.polito.tdp.flight.model;

public class IntegerPairs {
	private int suorceAirport;
	private int destinationAirport;
	/**
	 * @param suorceAirport
	 * @param destinationAirport
	 */
	public IntegerPairs(int suorceAirport, int destinationAirport) {
		super();
		this.suorceAirport = suorceAirport;
		this.destinationAirport = destinationAirport;
	}
	/**
	 * @return the suorceAirport
	 */
	public int getSuorceAirport() {
		return suorceAirport;
	}
	/**
	 * @param suorceAirport the suorceAirport to set
	 */
	public void setSuorceAirport(int suorceAirport) {
		this.suorceAirport = suorceAirport;
	}
	/**
	 * @return the destinationAirport
	 */
	public int getDestinationAirport() {
		return destinationAirport;
	}
	/**
	 * @param destinationAirport the destinationAirport to set
	 */
	public void setDestinationAirport(int destinationAirport) {
		this.destinationAirport = destinationAirport;
	}
	
	

}
