package com.travel.model;

public class Flights {

	private String flightNum;
	private Integer price;
	private Integer numSeats;
	private Integer numAvail;
	private String FromCity;
	private String ArivCity;
	
	
	public Flights() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Flights(String flightNum, Integer price, Integer numSeats, Integer numAvail, String fromCity,
			String arivCity) {
		super();
		this.flightNum = flightNum;
		this.price = price;
		this.numSeats = numSeats;
		this.numAvail = numAvail;
		FromCity = fromCity;
		ArivCity = arivCity;
	}
	
	public Flights(String flightNum) {
		super();
		this.flightNum = flightNum;
	}

	public String getFlightNum() {
		return flightNum;
	}
	public void setFlightNum(String flightNum) {
		this.flightNum = flightNum;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getNumSeats() {
		return numSeats;
	}
	public void setNumSeats(Integer numSeats) {
		this.numSeats = numSeats;
	}
	public Integer getNumAvail() {
		return numAvail;
	}
	public void setNumAvail(Integer numAvail) {
		this.numAvail = numAvail;
	}
	public String getFromCity() {
		return FromCity;
	}
	public void setFromCity(String fromCity) {
		FromCity = fromCity;
	}
	public String getArivCity() {
		return ArivCity;
	}
	public void setArivCity(String arivCity) {
		ArivCity = arivCity;
	}
	
	
}
