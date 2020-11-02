package es.exercise.pojo;

public class ProductScore implements Comparable {

    private final Long productId;
    private final double rate;

    public ProductScore(Long productId, double rate) {
        this.productId = productId;
        this.rate = rate;
    }

    public Long getProductId() {
        return productId;
    }

    public Double getRate() {
        return rate;
    }

    @Override
    public int compareTo(Object o) {
        ProductScore r = (ProductScore) o;
        return r.getRate().compareTo(this.getRate());
    }
}
