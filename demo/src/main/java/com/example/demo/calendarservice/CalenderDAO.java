package com.example.demo.calendarservice;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class CalenderDAO {
	
	public static List<CalenderPOJO> calenderList = new ArrayList<CalenderPOJO>();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
	static {
		calenderList.add(new CalenderPOJO("STORE001", "ALL", LocalTime.parse("13:30")));
		calenderList.add(new CalenderPOJO("STORE002", "SUNDAY", LocalTime.parse("13:30")));
		calenderList.add(new CalenderPOJO("STORE003", "MONDAY", LocalTime.parse("13:30")));
	}

	public ReqResEntity checkStoreAvailability(ReqResEntity req) {
		
		String status="";

		CalenderPOJO calender = calenderList.stream()
				.filter(x -> req.getStoreID().equals(x.getLocationID()))
				.findAny()
				.orElse(null);

		if (calender != null) {
			LocalDateTime reqDateTime = LocalDateTime.parse(req.getRequestDate(), formatter);
			LocalTime reqTime = reqDateTime.toLocalTime();
			
			String day= calender.getDay();
			int duration=reqTime.compareTo(calender.getCutOffTime());
			
//			System.out.println("Duration --"+duration);
//			System.out.println("reqDateTime.getDayOfWeek().toString()---"+reqDateTime.getDayOfWeek().toString());
//			System.out.println("Day ------"+day);
//			System.out.println("WEEKDAY of Request Date " + reqDateTime.getDayOfWeek());
			
			if(day.equals("ALL") && duration <= 0) {
				status= "Available";
			}
			else if(day.equals("ALL") && duration > 0) {
				status= "Not Available";
			}
			else if (!reqDateTime.getDayOfWeek().toString().equals(day)){
				status= "Not Available";
			}
			else if (reqDateTime.getDayOfWeek().toString().equals(day) && duration <= 0) {
				status= "Available";
			}
			else if (reqDateTime.getDayOfWeek().toString().equals(day) && duration > 0) {
				status= "Not Available";
			}
			
		}
		req.setStatus(status);
		return req;
	}
	
//	public static void main(String[] args) {
//		
//		System.out.println(
//		new CalendarDaoService().checkStoreAvailability(new ReqResEntity("STORE001","2021-06-27T13:30:00.000Z","")));
//		
//	}

}
