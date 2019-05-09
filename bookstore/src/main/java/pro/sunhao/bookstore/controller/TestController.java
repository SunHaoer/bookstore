package pro.sunhao.bookstore.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import pro.sunhao.bookstore.service.TestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

@CrossOrigin
@RestController
@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT}, produces = {"text/html;charset=utf-8"})
public class TestController {
    @Autowired
    TestService testService;

    SimpleAccountRealm realm = new SimpleAccountRealm();

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        realm.addAccount("dillon", "sun");
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(realm);
        System.out.println("1");
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("dillon", "sunhao");
        try {
            subject.login(token);
            System.out.println("ke yi deng lu");
        } catch (AuthenticationException e) {
            System.out.println("yi chang");
            e.printStackTrace();
        }
        return "嘎嘎";
    }
}
