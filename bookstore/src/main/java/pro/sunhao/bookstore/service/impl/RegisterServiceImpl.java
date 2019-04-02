package pro.sunhao.bookstore.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sunhao.bookstore.dao.RegisterDao;
import pro.sunhao.bookstore.util.PhoneCodeConfig;
import pro.sunhao.bookstore.pojo.UserBase;
import pro.sunhao.bookstore.service.RegisterService;
import pro.sunhao.bookstore.util.HttpUtils;
import pro.sunhao.bookstore.util.OperateJson;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    RegisterDao registerDao;

    @Override
    public JSONObject saveUserResultModel(String username, String password, int gender, String password2, String phone, String phoneCode, String phoneCodeInfo) {
        //registerDao.createCartTableByUserId(0);
        JSONObject outputJson = new JSONObject();
        OperateJson.putSuccess(outputJson, false);
        //System.out.println(username + " " + password + " " + password2 + " " + phone + " " + phoneCode + " " + phoneCodeInfo + "\n");
        if(username.isEmpty() || password.isEmpty() || password2.isEmpty() || phoneCode.isEmpty() || phoneCodeInfo == null || phoneCodeInfo.isEmpty()) {
            OperateJson.putParameterNull(outputJson);
        } else {
            if(!password.equals(password2) || !phone.equals(phoneCodeInfo.substring(0, 11)) || !phoneCode.equals(phoneCodeInfo.substring(12, 16))) {
                OperateJson.putParameterError(outputJson);
            } else {
                try {       // 此处需要事务回滚绑定
                    OperateJson.putSuccess(outputJson, true);
                    UserBase user = new UserBase(username, password, gender, phone);
                    registerDao.insertUser(user);
                    long id = user.getUserId();
                    registerDao.createCartTableByUserId(id);
                    //System.out.println(id);
                } catch (Exception e) {
                    OperateJson.putDataBaseError(outputJson);
                    e.printStackTrace();
                }
            }
        }
        return outputJson;
    }

    @Override
    public JSONObject validateUserNameResultModel(String username) {
        JSONObject outputJson = new JSONObject();
        OperateJson.putSuccess(outputJson, false);
        if(username.isEmpty()) {
            OperateJson.putParameterNull(outputJson);
        } else {
            try {
                Long userId = registerDao.selectUserByUserNameOrPhone(username);
                OperateJson.putSuccess(outputJson, true);
                if(userId == null) {
                    OperateJson.putIsLegal(outputJson, true);
                    //outputJson.put("isLegal", true);
                } else {
                    OperateJson.putIsLegal(outputJson, false);
                }
            } catch (Exception e) {
                OperateJson.putDataBaseError(outputJson);
                e.printStackTrace();
            }
        }
        return outputJson;
    }

    @Override
    public JSONObject getPhoneCodeResultModel(String phone) {
        JSONObject outputJson = new JSONObject();
        OperateJson.putSuccess(outputJson, false);
        if(phone.isEmpty()) {
            OperateJson.putParameterNull(outputJson);
        } else {
            Pattern phonePattern = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9])|(14[5,7])| (17[0,1,3,5-8]))\\d{8}$");
            Matcher matcher = phonePattern.matcher(phone);
            try {
                if(!matcher.matches() || registerDao.selectUserByUserNameOrPhone(phone) != null) {     // 手机号格式不合法或重复
                    OperateJson.putMessage(outputJson, "phone is not legal");
                } else {
                    try {
                        OperateJson.putSuccess(outputJson, true);
                        sendPhoneCode(phone, outputJson);
                        OperateJson.putIsLegal(outputJson, true);
                    } catch (Exception e) {
                        OperateJson.putMessage(outputJson, "send message error");
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                OperateJson.putDataBaseError(outputJson);
                e.printStackTrace();
            }
        }
        return outputJson;
    }

    private void sendPhoneCode(String phoneNum, JSONObject outputJson) throws Exception {
        String host = PhoneCodeConfig.host;
        String path = PhoneCodeConfig.path;
        String method = PhoneCodeConfig.method;
        String appCode = PhoneCodeConfig.appcode;
        String phoneCode = PhoneCodeConfig.getPhoneCode(4);
        Map<String, String> headers = new HashMap<String, String>();
        // 最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appCode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("mobile", phoneNum);
        querys.put("content", PhoneCodeConfig.getPhoneMessageContent(phoneNum, phoneCode));
        HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
        outputJson.put("phoneCode", phoneCode);
        System.out.println(response.toString());
        // 获取response的body
        System.out.println(EntityUtils.toString(response.getEntity()));
    }
}
