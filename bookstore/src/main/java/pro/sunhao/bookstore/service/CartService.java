package pro.sunhao.bookstore.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

public interface CartService {
    JSONObject getAddProductToCartByIdResultModel(long userId, long productId);

    JSONObject getRemoveProductToCartByIdResultModel(long userId, long productId);

    JSONObject getCartPageViewModel(long userId);
}
