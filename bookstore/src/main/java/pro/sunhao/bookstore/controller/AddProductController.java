package pro.sunhao.bookstore.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pro.sunhao.bookstore.info.ControllerMapping;
import pro.sunhao.bookstore.service.AddProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = ControllerMapping.ADDPRODUCT, method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT}, produces = {"text/html;charset=utf-8"})
public class AddProductController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private AddProductService addProductService;

    @RequestMapping(value = "/getAddProductViewModel")
    public String getAddProductViewModel() {
        JSONObject outputJson = addProductService.getAddProductViewModel();
        return outputJson.toString();
    }

    @RequestMapping(value = "/addProduct")
    public String getCartPageViewModel(@RequestParam(defaultValue = "") String productName, @RequestParam(defaultValue = "-1") double productPrice,
                                       @RequestParam(defaultValue = "") String productKind, @RequestParam(defaultValue = "-1") int productCount,
                                       @RequestParam(defaultValue = "") MultipartFile productImage, @RequestParam(defaultValue = "") String productDesc,
                                       HttpSession session ) {
        String uri = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/" + request.getContextPath();
        JSONObject outputJson = addProductService.getAddProductResultModel(productName, productPrice, productKind, productCount, productImage, productDesc, uri);
        return outputJson.toString();
    }

}
