package pro.sunhao.bookstore.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sunhao.bookstore.dao.ProductInfoDao;
import pro.sunhao.bookstore.info.ProductKindList;
import pro.sunhao.bookstore.pojo.ProductBase;
import pro.sunhao.bookstore.service.ProductInfoPageService;
import pro.sunhao.bookstore.util.ImageUtil;
import pro.sunhao.bookstore.util.OperateJson;
import pro.sunhao.bookstore.viewmodel.ProductInfoViewModel;

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
            OperateJson.putSuccess(outputJson, true);
            OperateJson.putProductKindList(outputJson);
            try {
                ProductBase product = productInfoDao.selectProductInfoById(productId);
                //byte productImage[] = ImageUtil.getImageByPath(productBase.getProductImagePath());
                //ProductInfoViewModel product = new ProductInfoViewModel(productBase.getProductId(), productBase.getProductName(), productBase.getProductPrice(), productBase.getProductDesc(), productBase.getProductCount(), productImage);
                outputJson.put("productInfo", product);
            } catch (Exception e) {
                OperateJson.putDataBaseError(outputJson);
                e.printStackTrace();
            }
        }
        return outputJson;
    }

}
