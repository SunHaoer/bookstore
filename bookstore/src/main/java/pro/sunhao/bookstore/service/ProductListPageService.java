package pro.sunhao.bookstore.service;

import com.alibaba.fastjson.JSONObject;

public interface ProductListPageService {

    JSONObject getProductListPageViewModel(String searchStr, String productKind, double priceLow, double priceHigh);

}
