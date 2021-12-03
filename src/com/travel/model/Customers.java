package com.travel.model;

public class Customers {
	private String custName;
	private String custID;
	
	public Customers() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Customers(String custName, String custID) {
		super();
		this.custName = custName;
		this.custID = custID;
	}

	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustID() {
		return custID;
	}
	public void setCustID(String custID) {
		this.custID = custID;
	}
	
}
