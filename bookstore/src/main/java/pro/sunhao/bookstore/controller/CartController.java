package pro.sunhao.bookstore.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sunhao.bookstore.info.ControllerMapping;
import pro.sunhao.bookstore.service.CartService;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = ControllerMapping.CART, method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT}, produces = {"text/html;charset=utf-8"})
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping(value = "/getCartPageViewModel")
    public String getCartPageViewModel(HttpSession session) {
        //session.setAttribute("loginUser", "1,2");
        long userId = session.getAttribute("loginUser") != null ? Long.parseLong(session.getAttribute("loginUser").toString().split(",")[0]) : -1;
        JSONObject outputJson = cartService.getCartPageViewModel(userId);
        return outputJson.toString();
    }

    @RequestMapping(value = "/addProductToCartById")
    public String addProductToCartById(@RequestParam(defaultValue="-1") long productId, HttpSession session) {
        //session.setAttribute("loginUser", "1,2");
        long userId = session.getAttribute("loginUser") != null ? Long.parseLong(session.getAttribute("loginUser").toString().split(",")[0]) : -1;
        JSONObject outputJson = cartService.getAddProductToCartByIdResultModel(userId, productId);
        return outputJson.toString();
    }

    @RequestMapping(value = "/subProductToCartById")
    public String removeProductToCartById(@RequestParam(defaultValue="-1") long productId, HttpSession session) {
        long userId = session.getAttribute("loginUser") != null ? Long.parseLong(session.getAttribute("loginUser").toString().split(",")[0]) : -1;
        JSONObject outputJson = cartService.getRemoveProductToCartByIdResultModel(userId, productId);
        return outputJson.toString();
    }

    @RequestMapping(value = "/deleteProductToCartById")
    public String deleteProductToCartById(@RequestParam(defaultValue="-1") long productId, HttpSession session) {
        long userId = session.getAttribute("loginUser") != null ? Long.parseLong(session.getAttribute("loginUser").toString().split(",")[0]) : -1;
        JSONObject outputJson = cartService.getDeleteProductToCartByIdResultModel(userId, productId);
        return outputJson.toString();
    }
}
