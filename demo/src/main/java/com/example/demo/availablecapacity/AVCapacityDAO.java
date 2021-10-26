package com.example.demo.availablecapacity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class AVCapacityDAO implements Callable<Integer> {
	

		int flag = 0;
		ReuestAvailableCapacityPOJO request;
		
		AVCapacityDAO(){}
		AVCapacityDAO(ReuestAvailableCapacityPOJO request) {
			this.request = request;
		}

		private static List<AVCapacity> avcapacityList = new ArrayList<>();

		static {
			try {
				avcapacityList.add(new AVCapacity("Store001", new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-19"), 0.0));
				avcapacityList.add(new AVCapacity("Store001", new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-20"), 2.0));
				avcapacityList.add(new AVCapacity("Store001", new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-21"), 2.0));
				avcapacityList.add(new AVCapacity("Store001", new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-22"), 0.0));
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
		}

		@Override
		public Integer call() throws Exception {
			String storeNumber = this.request.getStoreNo();
			Date reqDate = new SimpleDateFormat("yyyy-MM-dd").parse(this.request.getReqDate());
			// TODO Auto-generated method stub
			List<AVCapacity>cap=avcapacityList.stream().
			filter(capacity->capacity.getDate().compareTo(reqDate)==0).
			filter(capacity-> capacity.getNoOfOrdersAccepted() > 0).collect(Collectors.toList());
			return cap.size();
			
			
//			for(Capacity capacity:capacityList) {
//				int result = capacity.getDate().compareTo(reqDate);
//				if (result == 0 && capacity.getNoOfOrdersAccepted() > 0) {
//					flag = 1;
//					break;
//				}
//				if (result == 0 && capacity.getNoOfOrdersAccepted() == 0) {
//					flag = 0;
//					break;
//				}
//			}
			//return flag;
		}


}
