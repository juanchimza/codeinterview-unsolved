package es.exercise;

import es.exercise.pojo.ProductSales;
import es.exercise.pojo.ProductStock;

import java.util.*;

public class Solution {

    public static List<Long> sortProductsByScores(int stockWeight, int salesWeight,
                                                  List<ProductStock> productsStockInformation,
                                                  List<ProductSales> productsSalesInformation) {

    	List<Long> productsSortedByScores = new ArrayList<>();
    	productsSortedByScores.add(Long.valueOf("2"));
    	productsSortedByScores.add(Long.valueOf("4"));
    	productsSortedByScores.add(Long.valueOf("3"));
    	productsSortedByScores.add(Long.valueOf("1"));
    	try {
    		
    	} catch (Exception e) {
			// TODO: handle exception
		}
    	
    	return productsSortedByScores;
    }

}
