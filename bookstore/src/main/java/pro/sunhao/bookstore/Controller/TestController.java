package pro.sunhao.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pro.sunhao.bookstore.service.TestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Controller
public class TestController {
    @Autowired
    TestService testService;


    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        //testService.test("1", "2");

        return "嘎嘎";
    }

}
