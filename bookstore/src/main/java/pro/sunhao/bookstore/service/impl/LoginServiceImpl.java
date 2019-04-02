package pro.sunhao.bookstore.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sunhao.bookstore.dao.LoginDao;
import pro.sunhao.bookstore.pojo.UserBase;
import pro.sunhao.bookstore.service.LoginService;
import pro.sunhao.bookstore.util.OperateJson;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    @Override
    public JSONObject getLoginResultModel(String username, String password) {
        JSONObject outputJson = new JSONObject();
        OperateJson.putSuccess(outputJson, false);
        if(username.isEmpty() || password.isEmpty()) {
            OperateJson.putParameterNull(outputJson);
        } else {
            try {
                UserBase user = loginDao.selectUserByUsernameAndPassword(username, password);
                OperateJson.putSuccess(outputJson, true);
                if(user == null) {
                    OperateJson.putIsLegal(outputJson, false);
                    OperateJson.putMessage(outputJson, "username or password wrong");
                } else {
                    OperateJson.putIsLegal(outputJson, true);
                    outputJson.put("user", user.toSessionString());
                }
            } catch (Exception e) {
                OperateJson.putDataBaseError(outputJson);
                e.printStackTrace();
            }
        }
        return outputJson;
    }

}
