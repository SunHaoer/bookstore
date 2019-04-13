package pro.sunhao.bookstore.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sunhao.bookstore.dao.CartDao;
import pro.sunhao.bookstore.service.CartService;
import pro.sunhao.bookstore.util.OperateJson;
import pro.sunhao.bookstore.viewmodel.ProductCartViewModel;

import java.util.List;

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
                Integer productNum = cartDao.selectCountByProductId(userId, productId);
                productNum = productNum == null ? 0 : productNum;
                if(productNum == 0) {
                    cartDao.insertProductById(userId, productId);
                } else {
                    cartDao.addProductById(userId, productId);
                }
                OperateJson.putSuccess(outputJson, true);
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
                Integer productNum = cartDao.selectCountByProductId(userId, productId);
                productNum = productNum == null ? 0 : productNum;
                System.out.println(productNum);
                if(productNum <= 0) {
                    OperateJson.putParameterError(outputJson);
                } else if(productNum == 1) {
                    cartDao.deleteProductById(userId, productId);
                } else {
                    cartDao.subProductById(userId, productId);
                }
                OperateJson.putSuccess(outputJson, true);
            } catch (Exception e) {
                e.printStackTrace();
                OperateJson.putDataBaseError(outputJson);
            }
        }
        return outputJson;
    }

    @Override
    public JSONObject getCartPageViewModel(long userId) {
        JSONObject outputJson = new JSONObject();
        OperateJson.putSuccess(outputJson, false);
        if(userId < 0) {
            OperateJson.putParameterError(outputJson);
        } else {
            try {
                List<ProductCartViewModel> cartList = cartDao.getProductCartViewModel(userId);
                //System.out.println(cartList);
                double priceCount = 0;
                for (ProductCartViewModel product : cartList) {
                    System.out.println(product);
                    product.setPriceCount(product.getProductPrice() * product.getProductNum());
                    priceCount += product.getPriceCount();
                }
                outputJson.put("cartList", cartList);
                outputJson.put("priceCount", priceCount);
                OperateJson.putSuccess(outputJson, true);
            } catch (Exception e) {
                OperateJson.putDataBaseError(outputJson);
                e.printStackTrace();
            }
        }
        return  outputJson;
    }

    @Override
    public JSONObject getDeleteProductToCartByIdResultModel(long userId, long productId) {
        JSONObject outputJson = new JSONObject();
        OperateJson.putSuccess(outputJson, false);
        if(userId < 0 || productId < 0) {
            OperateJson.putParameterError(outputJson);
        } else {
            try {
                cartDao.deleteProductById(userId, productId);
                OperateJson.putSuccess(outputJson, true);
            } catch (Exception e) {
                e.printStackTrace();
                OperateJson.putDataBaseError(outputJson);
            }
        }
        return outputJson;
    }

}
