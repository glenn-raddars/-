package com.travel.model;

public class Hotels {
	private String location;
	private Integer price;
	private Integer numRooms;
	private Integer numAvail;
	private String HotelKey;
	
	public Hotels() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Hotels(String location, Integer price, Integer numRooms, Integer numAvail, String hotelKey) {
		super();
		this.location = location;
		this.price = price;
		this.numRooms = numRooms;
		this.numAvail = numAvail;
		HotelKey = hotelKey;
	}
	
	public Hotels(String hotelKey) {
		super();
		HotelKey = hotelKey;
	}

	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getNumRooms() {
		return numRooms;
	}
	public void setNumRooms(Integer numRooms) {
		this.numRooms = numRooms;
	}
	public Integer getNumAvail() {
		return numAvail;
	}
	public void setNumAvail(Integer numAvail) {
		this.numAvail = numAvail;
	}
	public String getHotelKey() {
		return HotelKey;
	}
	public void setHotelKey(String hotelKey) {
		HotelKey = hotelKey;
	}
	
	
}
