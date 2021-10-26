package com.example.demo.availablecapacity;

import java.util.Date;

public class AVCapacity {
	
	private String storeNo;
	private Date date;
	private Double noOfOrdersAccepted;
	public AVCapacity() {}
	public AVCapacity(String storeNo, Date date, Double noOfOrdersAccepted) {
		super();
		this.storeNo = storeNo;
		this.date = date;
		this.noOfOrdersAccepted = noOfOrdersAccepted;
	}
	public String getStoreNo() {
		return storeNo;
	}
	public void setStoreNo(String storeNo) {
		this.storeNo = storeNo;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getNoOfOrdersAccepted() {
		return noOfOrdersAccepted;
	}
	public void setNoOfOrdersAccepted(Double noOfOrdersAccepted) {
		this.noOfOrdersAccepted = noOfOrdersAccepted;
	}


}
