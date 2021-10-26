package com.example.demo.availablecapacity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import org.springframework.stereotype.Component;




@Component
public class AvailableCapacityDAO implements Callable<Integer>
{
	ReuestAvailableCapacityPOJO request;

	AvailableCapacityDAO() {
	}

	AvailableCapacityDAO(ReuestAvailableCapacityPOJO request) {
		this.request = request;
	}

	int flag = 0;

	private static List<AvailabileCapacity> availabilecapacityList = new ArrayList<>();

	static {

		try {
			availabilecapacityList.add(
					new AvailabileCapacity("Store001", "Prod1", new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-19"), 1.0));
			availabilecapacityList.add(
					new AvailabileCapacity("Store001", "Prod1", new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-20"), 3.0));
			availabilecapacityList.add(
					new AvailabileCapacity("Store001", "Prod1", new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-21"), 0.0));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		String storeNumber = this.request.getStoreNo();
		Date reqDate = new SimpleDateFormat("yyyy-MM-dd").parse(this.request.getReqDate());
			for(AvailabileCapacity availabilecapacity:availabilecapacityList) {
			int result = availabilecapacity.getDate().compareTo(reqDate);
			if (result == 0 && availabilecapacity.getAvailQty() > 0) {
				flag = 1;
				break;
			}
			if (result == 0 && availabilecapacity.getAvailQty() == 0) {
				flag = 0;
				break;
			}
		}
		return flag;
	}

}
