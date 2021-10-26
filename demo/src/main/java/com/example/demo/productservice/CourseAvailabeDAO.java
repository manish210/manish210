package com.example.demo.productservice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;



@Component
public class CourseAvailabeDAO {
	
static List<CourseAvailabe> courses;
	
	static {
		 courses = Arrays.asList(
				new CourseAvailabe("Spring", "Framework", 98, 20000),
				new CourseAvailabe("Spring Boot", "Framework", 95, 18000),
				new CourseAvailabe("API", "Microservices", 97, 22000),
				new CourseAvailabe("Microservices", "Microservices", 96, 25000),
				new CourseAvailabe("FullStack", "FullStack", 91, 14000), 
				new CourseAvailabe("AWS", "Cloud", 92, 21000),
				new CourseAvailabe("Azure", "Cloud", 99, 21000), 
				new CourseAvailabe("Docker", "Cloud", 92, 20000),
				new CourseAvailabe("Kubernetes", "Cloud", 91, 20000));
	}
	
	
	public Map<String, List<CourseAvailabe>> doGroupByCourse() {
		return
				courses.stream()
				.collect(Collectors.groupingBy(CourseAvailabe::getCategory));		
		
	}
	
	
	
	public Map<String, Long> doGroupByCourseCount(List<CourseAvailabe> courseList) {
		return
				courseList.stream()
				.collect(Collectors.groupingBy(CourseAvailabe::getCategory,Collectors.counting()));		
	}
	
	
	public Map<String, Long> doGroupByCourseCount() {
		return
				courses.stream()
				.collect(Collectors.groupingBy(CourseAvailabe::getCategory,Collectors.counting()));		
		
	}
	
	
	public void getByAppliedPredicate() {
		System.out.println(
				courses.stream().allMatch(course->course.getReviewScore()>9));	
		
	}
	
//	public static void main(String[] args) {
//		
//		new CourseAvailabeDAO().getByAppliedPredicate();
//		
//	}


}
