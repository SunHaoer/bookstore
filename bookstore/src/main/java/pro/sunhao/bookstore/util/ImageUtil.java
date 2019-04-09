package pro.sunhao.bookstore.util;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ImageUtil {

    public static byte[] getImageByPath(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        byte[] image = null;
        image = Files.readAllBytes(path);
        return image;
    }

}
