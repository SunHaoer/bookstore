package pro.sunhao.bookstore.viewmodel;

public class ProductCartViewModel {
    private Long productId;
    private String productName;
    private Double productPrice;
    private String productImagePath;
    private Integer productNum;
    private Double priceCount;

    public ProductCartViewModel(Long productId, String productName, Double productPrice, String productImagePath, Integer productNum) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productImagePath = productImagePath;
        this.productNum = productNum;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductImagePath() {
        return productImagePath;
    }

    public void setProductImagePath(String productImagePath) {
        this.productImagePath = productImagePath;
    }

    public Integer getProductNum() {
        return productNum;
    }

    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }

    public Double getPriceCount() {
        return priceCount;
    }

    public void setPriceCount(Double priceCount) {
        this.priceCount = priceCount;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"productId\":")
                .append(productId);
        sb.append(",\"productName\":\"")
                .append(productName).append('\"');
        sb.append(",\"productPrice\":")
                .append(productPrice);
        sb.append(",\"productImagePath\":\"")
                .append(productImagePath).append('\"');
        sb.append(",\"productNum\":")
                .append(productNum);
        sb.append(",\"priceCount\":")
                .append(priceCount);
        sb.append('}');
        return sb.toString();
    }
}
