package com.flightservices;

public class Flight {
	
	private String flightNumber;
	private String carrier;
	private String origin;
	private String departure;
	private String destination;
	private String arrival;
	private String aircraft;
	private Integer distance;
	private String travelTime;
	private String status;
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public String getAircraft() {
		return aircraft;
	}
	public void setAircraft(String aircraft) {
		this.aircraft = aircraft;
	}
	public Integer getDistance() {
		return distance;
	}
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	public String getTravelTime() {
		return travelTime;
	}
	public void setTravelTime(String travelTime) {
		this.travelTime = travelTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Flight [flightNumber=" + flightNumber + ", carrier=" + carrier + ", origin=" + origin + ", departure="
				+ departure + ", destination=" + destination + ", arrival=" + arrival + ", aircraft=" + aircraft
				+ ", distance=" + distance + ", travelTime=" + travelTime + ", status=" + status + "]";
	}
	
	

}
