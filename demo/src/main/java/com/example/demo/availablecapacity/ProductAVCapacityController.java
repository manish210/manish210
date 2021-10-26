package com.example.demo.availablecapacity;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductAVCapacityController {
	
	
	@PostMapping("/getProdAvailability")
	public ResponseEntity<ResponseAvailableCapacityPOJO> getProdAvailability(@RequestBody ReuestAvailableCapacityPOJO request ) throws InterruptedException, ExecutionException {
		
		

		
		
		
		ResponseEntity<ResponseAvailableCapacityPOJO> responseEntity=null;
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		Future<Integer> availabilityFuture = executorService.submit(new AvailableCapacityDAO(request));
		Future<Integer> capacityFuture = executorService.submit(new AVCapacityDAO(request));
		
		
		ResponseAvailableCapacityPOJO response= new ResponseAvailableCapacityPOJO();
		response.setStoreNo(request.getStoreNo());
		response.setProductId(request.getProductId());
		response.setReqQty(request.getReqQty());
		response.setReqDate(request.getReqDate());
		
		
		if(availabilityFuture.get()==1 && capacityFuture.get()==0) {
			response.setStatus("No Capacity");
			responseEntity= new ResponseEntity<ResponseAvailableCapacityPOJO>(response, HttpStatus.OK);
		}
		if(availabilityFuture.get()==1 && capacityFuture.get()==1) {
			response.setStatus("Available");
			responseEntity= new ResponseEntity<ResponseAvailableCapacityPOJO>(response, HttpStatus.OK);
		}
		if(availabilityFuture.get()==0 && capacityFuture.get()==1) {
			responseEntity= new ResponseEntity<ResponseAvailableCapacityPOJO>(HttpStatus.NO_CONTENT);
		}
		return responseEntity;
	}

}
