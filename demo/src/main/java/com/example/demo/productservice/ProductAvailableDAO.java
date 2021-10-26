package com.example.demo.productservice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductAvailableDAO {
	
	private static List<ProductAvailable> productAvailableList = new ArrayList<>();
	

	static {
		try {
			productAvailableList
			.add(new ProductAvailable("Prod6", "Shirt", "EACH", new SimpleDateFormat("yyyy-MM-dd").parse("2021-01-21")));
			productAvailableList
			.add(new ProductAvailable("Prod6", "Shirt", "EACH", new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-21")));
			productAvailableList
					.add(new ProductAvailable("Prod1", "Shirt", "EACH", new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-21")));
			productAvailableList.add(
					new ProductAvailable("Prod2", "Trousers", "EACH", new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-19")));
			productAvailableList
					.add(new ProductAvailable("Prod3", "Tie", "EACH", new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-22")));
			productAvailableList
					.add(new ProductAvailable("Prod3", "Tie", "EACH", new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-24")));

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<ProductAvailable> getSortedProduct() {
//		List<Product> sortedList = productList.stream().sorted((o1, o2) -> {
//			if (o1.getProductName() == o2.getProductName())
//				return o1.getLaunchDate().compareTo(o2.getLaunchDate());
//			else if (o1.getProductName().equalsIgnoreCase(o2.getProductName()))
//				return 1;
//			else
//				return -1;
//		}).collect(Collectors.toList());
		//Collections.reverse(sortedList);
		List<ProductAvailable> sortedList = productAvailableList.stream()
		        .sorted(availableProductComparator.reversed())
		        .collect(Collectors.toList());
		
		return sortedList;
		
	}
	
	public List<ProductAvailable> getSortedProduct(List<ProductAvailable> product) {
//		List<Product> sortedList = product.stream().sorted((o1, o2) -> {
//			if (o1.getProductId().equals(o2.getProductId())) {
//				return o1.getLaunchDate().compareTo(o2.getLaunchDate());
//			}
//			else if (o1.getProductId().equalsIgnoreCase(o2.getProductId()))
//				return 1;
//			else
//				return -1;
//		}).collect(Collectors.toList());
//		//Collections.reverse(sortedList);
//		return sortedList;
		List<ProductAvailable> sortedList = product.stream()
		        .sorted(availableProductComparator.reversed())
		        .collect(Collectors.toList());
		
		//product.sort(Comparator.comparing(Product::getProductId).thenComparing(Product::getLaunchDate).reversed());
		
		
		Comparator<ProductAvailable> comparator
	      =(p1,p2)->{
			   if(p1.getProductId() == p2.getProductId()) {
		        	return p1.getLaunchDate().compareTo(p2.getLaunchDate());
		        }
		        else if (!p1.getProductId().equalsIgnoreCase(p2.getProductId())) {
					return p1.getProductId().compareTo(p2.getProductId());
		        }
				else
					return -1;
		};
		
		product.sort(comparator.reversed());
		
		return product;
	}
	
	Comparator<ProductAvailable> availableProductComparator = new Comparator<ProductAvailable>() {
	    @Override
	    public int compare(ProductAvailable o1, ProductAvailable o2) {
	        if(o1.getProductId() == o2.getProductId()) {
	        	return o1.getLaunchDate().compareTo(o2.getLaunchDate());
	        }
	        else if (!o1.getProductId().equalsIgnoreCase(o2.getProductId())) 
	        {
	        	//System.out.println("here me"+o1.getProductId().compareTo(o2.getProductId()));
				return o1.getProductId().compareTo(o2.getProductId());
	        }
			else
				return -1;
	    }
	};

}
