package pro.sunhao.bookstore.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pro.sunhao.bookstore.service.HomePageService;

@CrossOrigin
@RestController
@RequestMapping(value="/index", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT}, produces = {"text/html;charset=utf-8"})
public class HomePageController {

    @Autowired
    public HomePageService homePageService;

    @RequestMapping(value="/getProductListViewModel")
    public String getProductListViewModel() {
        JSONObject outputJson = homePageService.getHomePageViewModel();
        //ProductListViewModel model = homePageService.getProductListViewModel();

        return outputJson.toString();
    }
}
