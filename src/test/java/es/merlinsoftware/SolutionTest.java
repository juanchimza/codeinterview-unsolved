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
		List<Long> productList = Arrays.asList(Long.valueOf("2"),Long.valueOf("4"),Long.valueOf("3"),Long.valueOf("1"));
		
		int stockWeight = 50;
		int salesWeight = 50;
		List<ProductStock> productsStockInformation = Arrays.asList(new ProductStock(Long.valueOf("1"), Long.valueOf("100000")),new ProductStock(Long.valueOf("2"), Long.valueOf("400000")),new ProductStock(Long.valueOf("3"), Long.valueOf("200000")),new ProductStock(Long.valueOf("4"), Long.valueOf("300000")));
		List<ProductSales> productsSalesInformation = Arrays.asList(new ProductSales(Long.valueOf("1"), Double.valueOf("50000")),new ProductSales(Long.valueOf("2"), Double.valueOf("100000")),new ProductSales(Long.valueOf("3"), Double.valueOf("100000")),new ProductSales(Long.valueOf("4"), Double.valueOf("75000")));
		List<Long> productsSortedByScores = Solution.sortProductsByScores(stockWeight, salesWeight, productsStockInformation, productsSalesInformation); 

		productsSortedByScores.forEach(System.out::println);
		Assert.assertEquals(productList,productsSortedByScores);
	}

}
