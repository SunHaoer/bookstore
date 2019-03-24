package pro.sunhao.bookstore.service;

import com.alibaba.fastjson.JSONObject;

public interface ProductInfoPageService {
    JSONObject getProductInfoViewModelById(long productId);
}
