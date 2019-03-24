package pro.sunhao.bookstore.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pro.sunhao.bookstore.service.ProductInfoPageService;

@RestController
@RequestMapping(value="/productInfo", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT}, produces = {"text/html;charset=utf-8"})
public class ProductInfoPageController {

    @Autowired
    private ProductInfoPageService productInfoPageService;

    @RequestMapping(value="/getProductInfoById")
    public String getProductInfoById(@RequestParam(defaultValue="-1") long productId) {
        JSONObject outputJson = productInfoPageService.getProductInfoById(productId);
        return outputJson.toString();
    }

}
