package pro.sunhao.bookstore.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
import pro.sunhao.bookstore.service.HomePageService;
import pro.sunhao.bookstore.util.OperateJson;

@Service
public class HomePageServiceImpl implements HomePageService {

    @Override
    public JSONObject getHomePageViewModel() {
        JSONObject outputJson = new JSONObject();
        if(true) {
            OperateJson.putSuccess(outputJson, true);
            OperateJson.putProductKindList(outputJson);
        }
        return outputJson;
    }

}
