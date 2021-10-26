package com.example.demo.calendarservice;

public class ReqResEntity {
	
	String storeID;
	String requestDate;
	String status;
	@Override
	public String toString() {
		return "ReqResEntity [storeID=" + storeID + ", requestDate=" + requestDate + ", status=" + status + "]";
	}
	public ReqResEntity() {}
	public ReqResEntity(String storeID, String requestDate, String status) {
		super();
		this.storeID = storeID;
		this.requestDate = requestDate;
		this.status = status;
	}
	public String getStoreID() {
		return storeID;
	}
	public void setStoreID(String storeID) {
		this.storeID = storeID;
	}
	public String getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


}
