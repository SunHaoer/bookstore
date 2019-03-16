package pro.sunhao.bookstore.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sunhao.bookstore.dao.RegisterDao;
import pro.sunhao.bookstore.info.PhoneCodeConfig;
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
    public JSONObject saveUserResultModel(String username, String password, int gender) {
        JSONObject outputJson = new JSONObject();
        outputJson.put("陈景鸭", "嘎嘎嘎");
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
                OperateJson.putSuccess(outputJson, true);
                outputJson.put("isLegal", false);
                Long userId = registerDao.selectUserByUserNameOrPhone(username);
                if(userId != null) {
                    outputJson.put("isLegal", true);
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
                    outputJson.put("message", "phone is not legal");
                } else {
                    try {
                        outputJson.put("success", true);
                        sendPhoneCode(phone, outputJson);
                        outputJson.put("isLegal", true);
                    } catch (Exception e) {
                        outputJson.put("message", "send message error");
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
        //System.out.println(response.toString());
        //获取response的body
        System.out.println(EntityUtils.toString(response.getEntity()));
    }
}
