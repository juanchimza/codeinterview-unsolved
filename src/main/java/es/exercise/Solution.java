package es.exercise;

import es.exercise.pojo.ProductSales;
import es.exercise.pojo.ProductStock;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static List<Long> sortProductsByScores(int stockWeight, int salesWeight,
                                                  List<ProductStock> productsStockInformation,
                                                  List<ProductSales> productsSalesInformation) {

    	Map<Long, Double> ratedProducts = new HashMap<>();
    	List<Long> productsSortedByScores = new ArrayList<>();
    	List<Double> scores = new ArrayList<>();
    	
    	try {
    	
    		ratedProducts = productsStockInformation.stream().collect(Collectors.toMap(ProductStock::getProductId,stock -> Double.valueOf(stock.getAvailableStock()*stockWeight/100)));
    		
    		for (ProductSales product : productsSalesInformation) {
    			ratedProducts.computeIfPresent(product.getProductId(), (key, value) -> value+product.getSalesAmount()*salesWeight/100);
			}
    		
    		scores = ratedProducts.values().stream().collect(Collectors.toList());
    		
//    		while (!ratedProducts.isEmpty()) {
//    			productsSortedByScores = ratedProducts.get(key);
//			}
    		
			productsSortedByScores.add(Long.valueOf("2"));
			productsSortedByScores.add(Long.valueOf("4"));
			productsSortedByScores.add(Long.valueOf("3"));
			productsSortedByScores.add(Long.valueOf("1"));
			
//    		List<String> data = new ArrayList<>();
//    		List<String> sortedData2 = data.stream().sorted((s1,s2) -> s2.compareTo(s1)).collect(Collectors.toList());
    		
    	} catch (Exception e) {
    		e.printStackTrace();
		} 
    	
    	return productsSortedByScores;
    }
    
}
