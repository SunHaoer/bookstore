package pro.sunhao.bookstore.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sunhao.bookstore.dao.ProductListDao;
import pro.sunhao.bookstore.pojo.ProductBase;
import pro.sunhao.bookstore.service.ProductListPageService;
import pro.sunhao.bookstore.util.OperateJson;

import java.util.List;

@Service
public class ProductListPageServiceImpl implements ProductListPageService {

    @Autowired
    private ProductListDao productListDao;

    @Override
    public JSONObject getProductListPageViewModel(String searchStr, String productKind, double priceLow, double priceHigh) {
        JSONObject outputJson = new JSONObject();
        OperateJson.putSuccess(outputJson, false);
        try {
            OperateJson.putSuccess(outputJson, true);
            OperateJson.putProductKindList(outputJson);
            List<ProductBase> productBaseList = productListDao.selectProductByParameter('%' + searchStr + '%', '%' + productKind + '%', priceLow, priceHigh);
            outputJson.put("productList", productBaseList);
        } catch (Exception e) {
            OperateJson.putDataBaseError(outputJson);
            e.printStackTrace();
        }

        //System.out.println(productBaseList);
        return outputJson;
    }

}
