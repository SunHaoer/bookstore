package pro.sunhao.bookstore.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value="/register", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT}, produces = {"text/html;charset=utf-8"})
public class RegisterController {

    @RequestMapping(value="/saveUser")
    public String saveUser(String userUsername, String userPassword, String userPhone, int userGender) {
        JSONObject outputJson = new JSONObject();

        return outputJson.toString();
    }

    @RequestMapping(value="/validateUserName")
    public String validateUserName(String userUsername) {
        JSONObject outputJson = new JSONObject();

        return outputJson.toString();
    }

    @RequestMapping(value="/getPhoneCode")
    public String getPhoneCode(String userPhone) {
        JSONObject outputJson = new JSONObject();

        return outputJson.toString();
    }

}
