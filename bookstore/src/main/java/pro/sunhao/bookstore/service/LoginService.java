package pro.sunhao.bookstore.service;

import com.alibaba.fastjson.JSONObject;

public interface LoginService {

    JSONObject getLoginResultModel(String username, String password);

}
