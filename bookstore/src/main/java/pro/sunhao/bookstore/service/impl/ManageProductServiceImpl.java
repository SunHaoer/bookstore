package pro.sunhao.bookstore.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sunhao.bookstore.dao.ManageProductDao;
import pro.sunhao.bookstore.pojo.ProductBase;
import pro.sunhao.bookstore.service.ManageProductService;
import pro.sunhao.bookstore.util.OperateJson;

import java.util.List;

@Service
public class ManageProductServiceImpl implements ManageProductService {

    @Autowired
    ManageProductDao manageProductDao;

    @Override
    public JSONObject getManageProductViewModel() {
        JSONObject outputJson = new JSONObject();
        OperateJson.putSuccess(outputJson, false);
        try {
            List<ProductBase> productList = manageProductDao.selectProduct();
            outputJson.put("productList", productList);
            OperateJson.putSuccess(outputJson, true);
        } catch (Exception e) {
            OperateJson.putDataBaseError(outputJson);
        }
        return outputJson;
    }

    @Override
    public JSONObject getUpdateProductResultModel(long productId, String productName, String productKind, double productPrice, String productDesc, int productCount) {
        JSONObject outputJson = new JSONObject();
        OperateJson.putSuccess(outputJson, false);
        if(productId < 0 || productPrice < 0 || productCount < 0 || productName.isEmpty() || productKind.isEmpty() || productDesc.isEmpty() ) {
            OperateJson.putParameterError(outputJson);
        } else {
            try {
                manageProductDao.updateProductById(productId, productName, productKind, productPrice, productDesc, productCount);
                OperateJson.putSuccess(outputJson, true);
            } catch (Exception e) {
                OperateJson.putDataBaseError(outputJson);
            }
        }
        return outputJson;
    }

    @Override
    public JSONObject getDeleteProductByIdResultModel(long productId) {
        JSONObject outputJson = new JSONObject();
        OperateJson.putSuccess(outputJson, false);
        if(productId < 0) {
            OperateJson.putParameterError(outputJson);
        } else {
            try {
                manageProductDao.deleteProductById(productId);
                OperateJson.putSuccess(outputJson, true);
            } catch (Exception e) {
                OperateJson.putDataBaseError(outputJson);
            }
        }
        return outputJson;
    }


}
