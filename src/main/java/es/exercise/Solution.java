package es.exercise;

import es.exercise.pojo.ProductScore;
import es.exercise.pojo.ProductSales;
import es.exercise.pojo.ProductStock;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Solution {

    public static List<Long> sortProductsByScores(int stockWeight, int salesWeight,
												  List<ProductStock> productsStockInformation,
												  List<ProductSales> productsSalesInformation) {

    	// 1. List validation.
    	if (productsStockInformation.size() != productsSalesInformation.size()) {
			// TODO: Review if we should throw an Exception in this case.
			Logger.getGlobal().log(Level.SEVERE, "Bad input parameters. Product list sizes are different.");
			return null;
		}

		Set<ProductScore> resultSet = new TreeSet<>();

    	// 2. Convert List to Map
		Map<Long, ProductStock> stockMap = productsStockInformation.parallelStream()
				.collect(Collectors.toMap(ProductStock::getProductId, productStock -> productStock));

		// 3. Iterate the other list.
		for (ProductSales productSales : productsSalesInformation) {

			final Long productId = productSales.getProductId();

			if (Objects.isNull(stockMap.get(productId))) {
				// TODO: Review if we should throw an Exception in this case.
				Logger.getGlobal().log(Level.SEVERE, "Bad input parameters. Product ID not found: " + productId);
				return null;
			}

			// 4. Calc Product Score
			double score = getProductScore(stockWeight, stockMap.get(productId).getAvailableStock(), salesWeight, productSales.getSalesAmount());

			// 5. Add to the result set.
			resultSet.add(new ProductScore(productId, score));
		}

		// 6. Map and collect product IDs.
    	return resultSet.stream().map(ProductScore::getProductId).collect(Collectors.toList());
    }

	/* Returns score for a given product. It receives weights for stock and sales,
        and its values (stock amount and sale amounts. */
    private static double getProductScore(int stockWeight, Long salesWeight, int stock, Double salesAmount) {

    	return stock * stockWeight + salesAmount * salesWeight;
    }

}
