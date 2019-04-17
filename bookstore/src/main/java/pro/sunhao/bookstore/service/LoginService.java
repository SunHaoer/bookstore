package pro.sunhao.bookstore.service;

import com.alibaba.fastjson.JSONObject;
import pro.sunhao.bookstore.pojo.UserBase;

public interface LoginService {

    JSONObject getLoginResultModel(String username, String password);

    JSONObject getLogoutResultModel();

    JSONObject getNotLimitResultModel();
}
