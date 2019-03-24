package pro.sunhao.bookstore.viewmodel;

public class ProductInfoViewModel {
    private Long productId;
    private String productName;
    private Integer productPrice;
    private String productDesc;
    private Integer productCount;
    private byte[] productImage;

    public ProductInfoViewModel(Long productId, String productName, Integer productPrice, String productDesc, Integer productCount, byte[] productImage) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDesc = productDesc;
        this.productCount = productCount;
        this.productImage = productImage;
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

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
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

    public byte[] getProductImage() {
        return productImage;
    }

    public void setProductImage(byte[] productImage) {
        this.productImage = productImage;
    }
}
