package pro.sunhao.bookstore.service;

import com.alibaba.fastjson.JSONObject;

public interface ManageProductService {
    JSONObject getManageProductViewModel();


    JSONObject getUpdateProductResultModel(long productId, String productName, String productKind, double productPrice, String productDesc, int productCount);

    JSONObject getDeleteProductByIdResultModel(long productId);
}
