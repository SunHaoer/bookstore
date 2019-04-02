package pro.sunhao.bookstore.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sunhao.bookstore.service.LoginService;

import javax.security.auth.Subject;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value="/login", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT}, produces = {"text/html;charset=utf-8"})
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

}
