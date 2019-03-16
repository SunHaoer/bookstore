package pro.sunhao.bookstore.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pro.sunhao.bookstore.service.RegisterService;

@CrossOrigin
@RestController
@RequestMapping(value="/register", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT}, produces = {"text/html;charset=utf-8"})
public class RegisterController {

    @Autowired
    RegisterService registerService;

    @RequestMapping(value="/saveUser")
    public String saveUser(@RequestParam(defaultValue="")String userUsername, @RequestParam(defaultValue="")String userPassword, @RequestParam(defaultValue="")String userPhone, @RequestParam(defaultValue="0")int userGender) {
        JSONObject outputJson = registerService.saveUserResultModel(userUsername, userPassword, userGender);

        return outputJson.toString();
    }

    @RequestMapping(value="/validateUserName")
    public String validateUserName(@RequestParam(defaultValue="")String userUsername) {
        JSONObject outputJson = registerService.validateUserNameResultModel(userUsername);
        return outputJson.toString();
    }

    @RequestMapping(value="/getPhoneCode")
    public String getPhoneCode(@RequestParam(defaultValue="")String userPhone) {
        JSONObject outputJson = registerService.getPhoneCodeResultModel(userPhone);
        System.out.println(outputJson.get("phoneCode"));
        outputJson.remove("phoneCode");
        return outputJson.toString();
    }

}
