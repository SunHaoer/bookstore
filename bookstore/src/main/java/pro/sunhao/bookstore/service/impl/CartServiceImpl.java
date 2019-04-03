package pro.sunhao.bookstore.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sunhao.bookstore.dao.CartDao;
import pro.sunhao.bookstore.service.CartService;
import pro.sunhao.bookstore.util.OperateJson;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;

    @Override
    public JSONObject getAddProductToCartByIdResultModel(long userId, long productId) {
        JSONObject outputJson = new JSONObject();
        OperateJson.putSuccess(outputJson, false);
        if(userId < 0 || productId < 0) {
            OperateJson.putParameterError(outputJson);
        } else {
            try {
                OperateJson.putSuccess(outputJson, true);
                int productNum = cartDao.selectCountByProductId(userId, productId);
                if(productNum == 0) {
                    cartDao.insertProductById(userId, productId);
                } else {
                    cartDao.addProductById(userId, productId);
                }
            } catch (Exception e) {
                e.printStackTrace();
                OperateJson.putDataBaseError(outputJson);
            }
        }
        return outputJson;
    }

    @Override
    public JSONObject getRemoveProductToCartByIdResultModel(long userId, long productId) {
        JSONObject outputJson = new JSONObject();
        OperateJson.putSuccess(outputJson, false);
        if(userId < 0 || productId < 0) {
            OperateJson.putParameterError(outputJson);
        } else {
            try {
                OperateJson.putSuccess(outputJson, true);
                int productNum = cartDao.selectCountByProductId(userId, productId);
                //System.out.println(productNum);
                if(productNum <= 0) {
                    OperateJson.putParameterError(outputJson);
                } else if(productNum == 1) {
                    cartDao.deleteProductById(userId, productId);
                } else {
                    cartDao.subProductById(userId, productId);
                }
            } catch (Exception e) {
                e.printStackTrace();
                OperateJson.putDataBaseError(outputJson);
            }
        }
        return outputJson;
    }

}
