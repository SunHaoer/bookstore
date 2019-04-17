package pro.sunhao.bookstore.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonAlias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pro.sunhao.bookstore.info.ControllerMapping;
import pro.sunhao.bookstore.service.LoginService;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = ControllerMapping.LOGIN, method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT}, produces = {"text/html;charset=utf-8"})
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value="/login")
    public String login(
            @RequestParam(defaultValue="")String userUsername, @RequestParam(defaultValue="")String userPassword, HttpSession session) {
        JSONObject outputJson = loginService.getLoginResultModel(userUsername, userPassword);
        if(outputJson.get("user") != null) {
            //System.out.println("login success");
            session.setAttribute("loginUser", outputJson.get("user"));
            outputJson.remove("user");
        }
        return outputJson.toString();
    }

    @RequestMapping(value="/logout")
    public String logout(HttpSession session) {
        JSONObject outputJson = loginService.getLogoutResultModel();
        session.removeAttribute("loginUser");
        return outputJson.toString();
    }

    @RequestMapping(value="/notLimit")
    public String notLimit() {
        JSONObject outputJson = loginService.getNotLimitResultModel();
        System.out.println("not login");
        return outputJson.toString();
    }

}
