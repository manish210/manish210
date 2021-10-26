package com.example.demo.calendarservice;

import java.time.LocalTime;

public class CalenderPOJO {
	
	public CalenderPOJO(String string, String string2, LocalTime parse) {
		// TODO Auto-generated constructor stub
	}

	public class CalendarPOJO {
		
		String locationID; 
		String Day; 
		LocalTime cutOffTime;
		public CalendarPOJO(){}
		public CalendarPOJO(String locationID, String day, LocalTime cutOffTime) {
			super();
			this.locationID = locationID;
			Day = day;
			this.cutOffTime = cutOffTime;
		}
		public String getLocationID() {
			return locationID;
		}
		public void setLocationID(String locationID) {
			this.locationID = locationID;
		}
		public String getDay() {
			return Day;
		}
		public void setDay(String day) {
			Day = day;
		}
		public LocalTime getCutOffTime() {
			return cutOffTime;
		}
		public void setCutOffTime(LocalTime cutOffTime) {
			this.cutOffTime = cutOffTime;
		}

	}

	public LocalTime getCutOffTime() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDay() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getLocationID() {
		// TODO Auto-generated method stub
		return null;
	}
}