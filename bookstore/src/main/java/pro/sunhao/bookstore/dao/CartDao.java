package pro.sunhao.bookstore.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface CartDao {

    int selectCountByProductId(long userId, long productId);

    void insertProductById(long userId, long productId);

    void addProductById(long userId, long productId);

    void deleteProductById(long userId, long productId);

    void subProductById(long userId, long productId);
}
