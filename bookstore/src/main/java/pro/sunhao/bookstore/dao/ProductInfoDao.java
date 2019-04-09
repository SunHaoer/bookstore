package pro.sunhao.bookstore.dao;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Repository;
import pro.sunhao.bookstore.pojo.ProductBase;

@Repository
public interface ProductInfoDao {

    public ProductBase selectProductInfoById(long productId);

}
