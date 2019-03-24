package pro.sunhao.bookstore.util;

import com.alibaba.fastjson.JSONObject;
import pro.sunhao.bookstore.info.ProductKindList;

public class OperateJson {

    public static void putParameterNull(JSONObject outputJson) {
        outputJson.put("message", "parameter is null");
    }

    public static void putParameterError(JSONObject outputJson) {
        outputJson.put("message", "parameter it not legal");
    }

    public static void putSuccess(JSONObject outputJson, boolean value) { outputJson.put("success", value); }

    public static void putDataBaseError(JSONObject outputJson) { outputJson.put("message", "database error"); }

    public static void putProductKindList(JSONObject outputJson) {
        outputJson.put("productKindList", ProductKindList.productKindList);
    }
}
