package com.travel.model;

public class Reservations {

	private String custName;
	private Integer resvType;
	private String resvKey;

	
	public Reservations() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Reservations(String custName, Integer resvType, String resvKey) {
		super();
		this.custName = custName;
		this.resvType = resvType;
		this.resvKey = resvKey;
	}


	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public Integer getResvType() {
		return resvType;
	}
	public void setResvType(Integer resvType) {
		this.resvType = resvType;
	}
	public String getResvKey() {
		return resvKey;
	}
	public void setResvKey(String resvKey) {
		this.resvKey = resvKey;
	}
	
}
