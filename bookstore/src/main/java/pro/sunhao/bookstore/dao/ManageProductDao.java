package pro.sunhao.bookstore.dao;

import org.springframework.stereotype.Repository;
import pro.sunhao.bookstore.pojo.ProductBase;

import java.util.List;

@Repository
public interface ManageProductDao {

    List<ProductBase> selectProduct();

    void updateProductById(long productId, String productName, String productKind, double productPrice, String productDesc, int productCount);

    void deleteProductById(long productId);
}
