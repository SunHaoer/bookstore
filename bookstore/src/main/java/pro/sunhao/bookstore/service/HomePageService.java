package pro.sunhao.bookstore.service;

import com.alibaba.fastjson.JSONObject;

public interface HomePageService {

    /**
     * 获取商品种类名称列表
     * @return
     */
    JSONObject getHomePageViewModel(String loginUser);
}
