package pro.sunhao.bookstore.dao;

import org.springframework.stereotype.Repository;
import pro.sunhao.bookstore.viewmodel.ProductCartViewModel;

import java.util.List;

@Repository
public interface CartDao {

    Integer selectCountByProductId(long userId, long productId);

    void insertProductById(long userId, long productId);

    void addProductById(long userId, long productId);

    void deleteProductById(long userId, long productId);

    void subProductById(long userId, long productId);

    List<ProductCartViewModel> getProductCartViewModel(long userId);
}
