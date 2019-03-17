package pro.sunhao.bookstore.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pro.sunhao.bookstore.service.RegisterService;

import javax.servlet.http.HttpSession;

@CrossOrigin
@RestController
@RequestMapping(value="/register", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT}, produces = {"text/html;charset=utf-8"})
public class RegisterController {

    @Autowired
    RegisterService registerService;

    @RequestMapping(value="/saveUser")
    public String saveUser(
            @RequestParam(defaultValue="")String userUsername, @RequestParam(defaultValue="")String userPassword, @RequestParam(defaultValue="")String userPhone, @RequestParam(defaultValue="0")int userGender,
            @RequestParam(defaultValue="")String password2, @RequestParam(defaultValue="")String phoneCode, @RequestParam(defaultValue="")HttpSession session) {
        JSONObject outputJson = registerService.saveUserResultModel(userUsername, userPassword, userGender);

        return outputJson.toString();
    }

    @RequestMapping(value="/validateUsername")
    @ResponseBody
    public String validateUsername(@RequestParam(defaultValue="")String userUsername) {
        JSONObject outputJson = registerService.validateUserNameResultModel(userUsername);
        System.out.println("validateUsername");
        return outputJson.toString();
    }

    @RequestMapping(value="/getPhoneCode")
    public String getPhoneCode(@RequestParam(defaultValue="")String userPhone, HttpSession session) {
        JSONObject outputJson = registerService.getPhoneCodeResultModel(userPhone);
        //System.out.println(outputJson.get("phoneCode"));
        session.setAttribute("phoneCode", userPhone + "," + outputJson.get("phoneCode"));
        outputJson.remove("phoneCode");
        return outputJson.toString();
    }

}
