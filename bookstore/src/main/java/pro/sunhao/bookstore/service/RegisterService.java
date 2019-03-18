package pro.sunhao.bookstore.service;

import com.alibaba.fastjson.JSONObject;

public interface RegisterService {
    JSONObject saveUserResultModel(String username, String password, int gender, String phone, String password2, String phoneCode, String phoneCodeInfo);

    JSONObject validateUserNameResultModel(String username);

    JSONObject getPhoneCodeResultModel(String phone);
}
