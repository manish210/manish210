package com.example.demo.productservice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

public class ProductAvailableController {
	
private static final Logger logger = LoggerFactory.getLogger(ProductAvailableController.class);
	
	
	@Autowired
	ProductAvailableDAO service;
	@Autowired
	CourseAvailabeDAO courseService;
	
	
	@GetMapping("/getsortProducts")
	public List<ProductAvailable> getAllSortedProduct(){
		logger.info("sortProducts get method endpoint triggred");
		return service.getSortedProduct();
	}
	
	@GetMapping("/getcourseGrpByCategory2")
	public Map<String,List<CourseAvailabe>> getcourseGrpByCategory2(){
		logger.info("getcourseGrpByCategory get method endpoint triggred");
		return courseService.doGroupByCourse();
		
	}
	
	@PostMapping("/getcourseCountByCategory")
	public Map<String, Long> getcourseGrpByCategory(@RequestBody Map<String,List<CourseAvailabe>> courseMap){
		logger.info("getcourseGrpByCategory get method endpoint triggred");
		return courseService.doGroupByCourseCount(courseMap.get("courseList"));
		//return courseService.doGroupByCourseCount();
		
	}
	
	@GetMapping("/getcourseGrpByCategoryCount")
	public Map<String, Long> getcourseGrpByCategoryCount(){
		logger.info("getcourseGrpByCategoryCount get method endpoint triggred");
		return courseService.doGroupByCourseCount();
	}
	
	
	@PostMapping("/sortProducts")	
	public Map<String,List<ProductAvailable>> getSortedProduct(@RequestBody Map<String,List<ProductAvailable>> productmap){
		logger.info("sortProducts post method endpoint triggred");
		Map response = new HashMap<String, List<ProductAvailable>>();
		response.put("sortedProductList", service.getSortedProduct(productmap.get("productList")));
		return response;
	}

}
