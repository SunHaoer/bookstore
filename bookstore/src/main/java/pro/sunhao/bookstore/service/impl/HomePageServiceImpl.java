package pro.sunhao.bookstore.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
import pro.sunhao.bookstore.service.HomePageService;
import pro.sunhao.bookstore.util.OperateJson;

@Service
public class HomePageServiceImpl implements HomePageService {

    @Override
    public JSONObject getHomePageViewModel(String loginUser) {
        System.out.println(loginUser);
        JSONObject outputJson = new JSONObject();
        if(true) {
            OperateJson.putSuccess(outputJson, true);
            OperateJson.putProductKindList(outputJson);
            if(loginUser != null) {
                outputJson.put("loginUsername", loginUser.split(",")[1]);
            }
        }
        return outputJson;
    }

}
