package pro.sunhao.bookstore.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface AddProductDao {

    void insertProduct(String productName, String productKind, double productPrice, String productDesc, int productCount, String productImagePath);

}
