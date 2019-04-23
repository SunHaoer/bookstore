package pro.sunhao.bookstore.service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;

public interface ProductListPageService {

    JSONObject getProductListPageViewModel(String searchStr, String productKind, double priceLow, double priceHigh, Page page, int pageNum);

}
