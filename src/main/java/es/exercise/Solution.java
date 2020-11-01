package es.exercise;

import es.exercise.pojo.ProductSales;
import es.exercise.pojo.ProductStock;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static List<Long> sortProductsByScores(int stockWeight, int salesWeight,
                                                  List<ProductStock> productsStockInformation,
                                                  List<ProductSales> productsSalesInformation) {

    	Map<Long, Double> ratedProducts;
    	List<Long> productsSortedByScores = new ArrayList<>();
    	List<Double> scores;
    	
    	try {
    	
    		ratedProducts = productsStockInformation.stream().collect(Collectors.toMap(ProductStock::getProductId,stock -> Double.valueOf(stock.getAvailableStock() * stockWeight / 100)));
    		
    		for (ProductSales product : productsSalesInformation) {
    			ratedProducts.computeIfPresent(product.getProductId(), (key, value) -> value+product.getSalesAmount()*salesWeight/100);
			}
    		
    		scores = new ArrayList<>(ratedProducts.values());
    		
    		while (productsSortedByScores.size()<productsStockInformation.size()) {
    			Double maxValue = scores.stream()
    			      .mapToDouble(v -> v)
    			      .max().orElseThrow(NoSuchElementException::new);
    			
    			Long key = ratedProducts
    				      .entrySet()
    				      .stream()
    				      .filter(entry -> maxValue.equals(entry.getValue()))
    				      .map(Map.Entry::getKey).findFirst().get();
    			
    			productsSortedByScores.add(key);
    			scores.remove(maxValue);
			}
    		
    	} catch (Exception e) {
    		e.printStackTrace();
		} 
    	
    	return productsSortedByScores;
    }
    
}
