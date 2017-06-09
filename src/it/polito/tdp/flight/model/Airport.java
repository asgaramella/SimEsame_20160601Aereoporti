package it.polito.tdp.flight.model;

import com.javadocmd.simplelatlng.LatLng;

public class Airport implements Comparable<Airport>{
	
	private int airportId ;
	private String name ;
	private String city ;
	private String country ;
	private String iataFaa ;
	private String icao ;
	private LatLng coords;
	private float timezone ;
	private String dst ;
	private String tz ;
	
	public Airport(int airportId, String name, String city, String country, String iataFaa, String icao,
			LatLng coords, float timezone, String dst, String tz) {
		super();
		this.airportId = airportId;
		this.name = name;
		this.city = city;
		this.country = country;
		this.iataFaa = iataFaa;
		this.icao = icao;
		this.coords=coords;
		this.timezone = timezone;
		this.dst = dst;
		this.tz = tz;
	}

	public int getAirportId() {
		return airportId;
	}

	public void setAirportId(int airportId) {
		this.airportId = airportId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getIataFaa() {
		return iataFaa;
	}

	public void setIataFaa(String iataFaa) {
		this.iataFaa = iataFaa;
	}

	public String getIcao() {
		return icao;
	}

	public void setIcao(String icao) {
		this.icao = icao;
	}

	
	public LatLng getCoords() {
		return coords;
	}
	
	public void setCoords(LatLng coords) {
		this.coords = coords;
	}

	public float getTimezone() {
		return timezone;
	}

	public void setTimezone(float timezone) {
		this.timezone = timezone;
	}

	public String getDst() {
		return dst;
	}

	public void setDst(String dst) {
		this.dst = dst;
	}

	public String getTz() {
		return tz;
	}

	public void setTz(String tz) {
		this.tz = tz;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + airportId;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Airport other = (Airport) obj;
		if (airportId != other.airportId)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return  name ;
	}

	@Override
	public int compareTo(Airport other) {
		// TODO Auto-generated method stub
		return this.name.compareTo(other.name);
	}
	
	

}
