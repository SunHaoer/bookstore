package pro.sunhao.bookstore.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.multipart.MultipartFile;

public interface AddProductService {


    JSONObject getAddProductResultModel(String productName, double productPrice, String productKind, int productCount, MultipartFile productImage, String productDesc);
}
