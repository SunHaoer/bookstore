package pro.sunhao.bookstore.dao;

import org.springframework.stereotype.Repository;
import pro.sunhao.bookstore.pojo.ProductBase;

import java.util.List;

@Repository
public interface ProductListDao {

    List<ProductBase> selectProductByParameter(String searchStr, String productKind, double priceLow, double priceHigh);

}
