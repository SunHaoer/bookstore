package pro.sunhao.bookstore.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import pro.sunhao.bookstore.service.AddProductService;
import pro.sunhao.bookstore.util.OperateJson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

@Service
public class AddProductServiceImpl implements AddProductService {

    @Override
    public JSONObject getAddProductResultModel(String productName, double productPrice, String productKind, int productCount, MultipartFile productImage, String productDesc) {
        JSONObject outputJson = new JSONObject();
        OperateJson.putSuccess(outputJson, false);
        if(productPrice < 0 || productCount < 0 || productName.isEmpty() || productKind.isEmpty() || productDesc.isEmpty()) {
            OperateJson.putParameterError(outputJson);
        } else {
            String imagePath = saveImage(productImage, productName, outputJson);
            if("ok".equals(outputJson.get("message"))) {
                outputJson.remove("message");
                System.out.println(imagePath);
                OperateJson.putSuccess(outputJson, true);
            }
        }
        return outputJson;
    }

    private String saveImage(MultipartFile productImage, String productName, JSONObject outputJson) {
        String path = null;
        if (productImage != null) {
            String name = productImage.getOriginalFilename();
            String type = name.indexOf(".") != -1 ? name.substring(name.lastIndexOf(".") + 1, name.length()) : null;
            if (type != null) {
                if ("GIF".equals(type.toUpperCase()) || "PNG".equals(type.toUpperCase()) || "JPG".equals(type.toUpperCase())) {
                    name = productName + "_" + UUID.randomUUID() + "." + type;
                    try {   // 存放图片
                        path = ResourceUtils.getURL("classpath:").getPath() + "static/image/product/" + name;
                        productImage.transferTo(new File(path));
                        OperateJson.putMessage(outputJson, "ok");
                    } catch (IOException e) {
                        OperateJson.putMessage(outputJson, "store image error");
                        e.printStackTrace();
                    }
                }
            } else {
                OperateJson.putMessage(outputJson, "file not legal");
            }
        } else {
            OperateJson.putMessage(outputJson, "file is empty");
        }
        return path;
    }




}
