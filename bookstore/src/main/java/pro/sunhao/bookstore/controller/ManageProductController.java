package pro.sunhao.bookstore.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sunhao.bookstore.service.ManageProductService;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value="/manageProduct", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT}, produces = {"text/html;charset=utf-8"})
public class ManageProductController {

    @Autowired
    ManageProductService manageProductService;

    @RequestMapping(value="/getManageProductViewModel")
    public String getManageProductViewModel(HttpSession session) {
        JSONObject outputJson = manageProductService.getManageProductViewModel();
        return outputJson.toString();
    }

    @RequestMapping(value="/updateProductById")
    public String updateProductById(
            @RequestParam(defaultValue="-1")long productId, @RequestParam(defaultValue="")String productName,
            @RequestParam(defaultValue="")String productKind, @RequestParam(defaultValue="-1")double productPrice,
            @RequestParam(defaultValue="")String productDesc, @RequestParam(defaultValue="-1")int productCount,
            HttpSession session) {
        JSONObject outputJson = manageProductService.getUpdateProductResultModel(productId, productName, productKind, productPrice, productDesc, productCount);
        return outputJson.toString();
    }

    @RequestMapping(value="/deleteProductById")
    public String deleteProductById(
            @RequestParam(defaultValue="-1")long productId, HttpSession session) {
        JSONObject outputJson = manageProductService.getDeleteProductByIdResultModel(productId);
        return outputJson.toString();
    }

}
