package es.exercise.pojo;

public class ProductSales {
    Long productId;
    Double salesAmount;

    public ProductSales(Long productId, Double salesAmount) {
        this.productId = productId;
        this.salesAmount = salesAmount;
    }

    public Long getProductId() {
        return productId;
    }

    public Double getSalesAmount() {
        return salesAmount;
    }

	@Override
	public String toString() {
		return "ProductSales [productId=" + productId + ", salesAmount=" + salesAmount + "]";
	}
}
