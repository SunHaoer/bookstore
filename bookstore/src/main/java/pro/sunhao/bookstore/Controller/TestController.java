package pro.sunhao.bookstore.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
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


    @RequestMapping("/test")
    @ResponseBody
    public String test(HttpSession session) {
        //testService.test("1", "2");
        //System.out.println(session.getAttribute("lala"));
        session.setAttribute("lala", "sun,hao");
        String str = session.getAttribute("lala").toString();
        System.out.println("sun".equals(str.split(",")[0]));
        System.out.println("hao".equals(str.split(",")[1]));
        return "嘎嘎";
    }

    @RequestMapping(value = "/getImage" , method = RequestMethod.GET, produces = {
            MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_GIF_VALUE, MediaType.IMAGE_PNG_VALUE })
    @ResponseBody
    public String getImg() {
        Path path = Paths.get("C:\\Users\\Public\\Pictures\\Sample Pictures\\Koala.jpg");
        byte[] data = null;
        try {
            data = Files.readAllBytes(path);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject outputJson = new JSONObject();
        outputJson.put("image", data);
        return outputJson.toString();
    }

}
