package pro.sunhao.bookstore.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sunhao.bookstore.service.ProductListPageService;

@RestController
@RequestMapping(value = "/productList", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT}, produces = {"text/html;charset=utf-8"})
public class ProductListPageController {

    @Autowired
    private ProductListPageService productListPageService;

    @RequestMapping(value = "/getProductListPageViewModel")
    public String getProductListPageViewModel(
            @RequestParam(defaultValue = "") String searchStr, @RequestParam(defaultValue = "") String productKind,
            @RequestParam(defaultValue = "0") double priceLow, @RequestParam(defaultValue = Integer.MAX_VALUE + "") double priceHigh,
            @RequestParam(defaultValue = "1") int nowPage, @RequestParam(defaultValue = "10") int pageNum) {
        JSONObject outputJson = productListPageService.getProductListPageViewModel(searchStr, productKind, priceLow, priceHigh);
        return outputJson.toString();
    }
}
