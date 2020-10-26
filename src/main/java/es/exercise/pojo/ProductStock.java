package es.exercise.pojo;

public class ProductStock {
    Long productId;
    Long availableStock;

    public ProductStock(Long productId, Long availableStock) {
        this.productId = productId;
        this.availableStock = availableStock;
    }

    public Long getProductId() {
        return productId;
    }

    public Long getAvailableStock() {
        return availableStock;
    }

}
