package es.merlinsoftware;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import es.exercise.Solution;
import es.exercise.pojo.ProductSales;
import es.exercise.pojo.ProductStock;

public class SolutionTest {
	
	@Test
	public void sortProductsByScoresTest() {
		List<Long> productList = Arrays.asList(Long.getLong("2"),Long.getLong("4"),Long.getLong("3"),Long.getLong("1"));
		
		int stockWeight = 0;
		int salesWeight = 0;
		List<ProductStock> productsStockInformation = null;
		List<ProductSales> productsSalesInformation = null;
		List<Long> productsSortedByScores = Solution.sortProductsByScores(stockWeight, salesWeight, productsStockInformation, productsSalesInformation); 

		productsSortedByScores.forEach(System.out::println);
		Assert.assertEquals(productList,productsSortedByScores);
	}

}
