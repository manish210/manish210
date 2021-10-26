package com.example.demo.calendarservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



public class CalendarController {
	
	@Autowired
	
	CalenderDAO service;
	
	@PostMapping("/findStoreAvailability")
	
	public ResponseEntity<ReqResEntity> findStoreAvailability(@RequestBody ReqResEntity request) {
		return new ResponseEntity<ReqResEntity>(service.checkStoreAvailability(request), HttpStatus.OK);
		//service.checkStoreAvailability(request);
	} 


}
