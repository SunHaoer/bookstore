package pro.sunhao.bookstore.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
import pro.sunhao.bookstore.info.ProductKindList;
import pro.sunhao.bookstore.service.HomePageService;

@Service
public class HomePageServiceImpl implements HomePageService {

    @Override
    public JSONObject getHomePageViewModel() {
        JSONObject outputJson = new JSONObject();
        if(true) {
            outputJson.put("productKindList", ProductKindList.productKindList);
            outputJson.put("success", true);
        } else {
            outputJson.put("message", "");
        }
        return outputJson;
    }

}
