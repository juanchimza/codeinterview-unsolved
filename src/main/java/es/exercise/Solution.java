package es.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import es.exercise.pojo.ProductSales;
import es.exercise.pojo.ProductStock;

public class Solution {

    public static List<Long> sortProductsByScores(int stockWeight, int salesWeight,
                                                  List<ProductStock> productsStockInformation,
                                                  List<ProductSales> productsSalesInformation) {

    	Map<Long, Double> ratedProducts = new HashMap<>();
    	List<Long> idProductsSortedByScores = new ArrayList<>();
    	
    	try {
    	
    		ratedProducts = productsStockInformation.parallelStream().collect(Collectors.toMap(ProductStock::getProductId,stock -> Double.valueOf((stock.getAvailableStock()*stockWeight))));
    		
    		for (ProductSales product : productsSalesInformation) {
    			ratedProducts.computeIfPresent(product.getProductId(), (key, value) -> value+product.getSalesAmount()*salesWeight);
			}
    		
			Map<Long, Double> productsSortedByScores = ratedProducts.entrySet().stream()
    				  .sorted(Map.Entry.<Long, Double>comparingByValue().reversed())
    				  .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(unordered, ordered) -> unordered, LinkedHashMap::new));
    		
			idProductsSortedByScores = productsSortedByScores.keySet().stream().collect(Collectors.toCollection(ArrayList::new));
    		
    	} catch (Exception e) {
    		e.printStackTrace();
		} 
    	
    	return idProductsSortedByScores;
    }
    
}
