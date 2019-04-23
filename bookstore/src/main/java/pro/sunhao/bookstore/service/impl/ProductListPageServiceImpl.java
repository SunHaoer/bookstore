package pro.sunhao.bookstore.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
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
    public JSONObject getProductListPageViewModel(String searchStr, String productKind, double priceLow, double priceHigh, Page page, int pageNum) {
        JSONObject outputJson = new JSONObject();
        OperateJson.putSuccess(outputJson, false);
        try {
            //OperateJson.putProductKindList(outputJson);
            List<ProductBase> productBaseList = productListDao.selectProductByParameter('%' + searchStr + '%', '%' + productKind + '%', priceLow, priceHigh);
            outputJson.put("productList", productBaseList);
            PageInfo pageInfo = new PageInfo<PageInfo>(page.getResult());
            outputJson.put("pageNum", pageNum);
            outputJson.put("pagesCount", pageInfo.getPages());
            OperateJson.putSuccess(outputJson, true);
        } catch (Exception e) {
            OperateJson.putDataBaseError(outputJson);
            e.printStackTrace();
        }
        return outputJson;
    }

}
