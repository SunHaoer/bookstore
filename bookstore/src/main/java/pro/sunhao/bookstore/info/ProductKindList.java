package pro.sunhao.bookstore.info;

import java.util.ArrayList;
import java.util.List;

public class ProductKindList {
    static public List<String> productKindList = new ArrayList<String>();

    static {
        productKindList.add("语文");
        productKindList.add("数学");
        productKindList.add("英语");
        productKindList.add("物理");
        productKindList.add("化学");
        productKindList.add("生物");
        productKindList.add("历史");
        productKindList.add("地理");
    }
}
