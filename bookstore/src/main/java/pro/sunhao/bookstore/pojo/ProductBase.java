package pro.sunhao.bookstore.pojo;

public class ProductBase {
    private Long productId;
    private String productName;
    private Double productPrice;
    private String productDesc;
    private Integer productCount;
    private String productImagePath;

    public void setProductImagePath(String productImagePath) {
        this.productImagePath = productImagePath;
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

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public String getProductImagePath() {
        return productImagePath;
    }
}
