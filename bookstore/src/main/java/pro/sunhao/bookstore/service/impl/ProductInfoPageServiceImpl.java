package pro.sunhao.bookstore.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sunhao.bookstore.dao.ProductInfoDao;
import pro.sunhao.bookstore.pojo.ProductBase;
import pro.sunhao.bookstore.service.ProductInfoPageService;
import pro.sunhao.bookstore.util.OperateJson;

@Service
public class ProductInfoPageServiceImpl implements ProductInfoPageService {

    @Autowired
    ProductInfoDao productInfoDao;

    @Override
    public JSONObject getProductInfoViewModelById(long productId) {
        JSONObject outputJson = new JSONObject();
        OperateJson.putSuccess(outputJson, false);
        if(productId == -1) {
            OperateJson.putParameterNull(outputJson);
        } else {
            OperateJson.putProductKindList(outputJson);
            try {
                ProductBase product = productInfoDao.selectProductInfoById(productId);
                outputJson.put("productInfo", product);
                OperateJson.putSuccess(outputJson, true);
            } catch (Exception e) {
                OperateJson.putDataBaseError(outputJson);
                e.printStackTrace();
            }
        }
        return outputJson;
    }

}
