package com.travel.model;

public class Bus {
	private String location;
	private Integer price;
	private Integer numBus;
	private Integer numAvail;
	private String BusKey;
	
	public Bus() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Bus(String location, Integer price, Integer numBus, Integer numAvail, String busKey) {
		super();
		this.location = location;
		this.price = price;
		this.numBus = numBus;
		this.numAvail = numAvail;
		BusKey = busKey;
	}

	public Bus(String busKey) {
		super();
		BusKey = busKey;
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
	public Integer getNumBus() {
		return numBus;
	}
	public void setNumBus(Integer numBus) {
		this.numBus = numBus;
	}
	public Integer getNumAvail() {
		return numAvail;
	}
	public void setNumAvail(Integer numAvail) {
		this.numAvail = numAvail;
	}
	public String getBusKey() {
		return BusKey;
	}
	public void setBusKey(String busKey) {
		BusKey = busKey;
	}
	
	
}
