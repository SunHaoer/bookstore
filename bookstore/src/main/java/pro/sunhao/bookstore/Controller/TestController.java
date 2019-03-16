package pro.sunhao.bookstore.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pro.sunhao.bookstore.service.TestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

@Controller
public class TestController {
    @Autowired
    TestService testService;


    @RequestMapping("/test")
    @ResponseBody
    public String test(int codeLength) {
        testService.test("1", "2");
        //return stringBuilder.toString();
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
