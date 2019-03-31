package pro.sunhao.bookstore.util;

import com.alibaba.fastjson.JSONObject;
import pro.sunhao.bookstore.info.ProductKindList;

public class OperateJson {

    public static void putParameterNull(JSONObject json) {
        json.put("message", "parameter is null");
    }

    public static void putParameterError(JSONObject json) {
        json.put("message", "parameter it not legal");
    }

    public static void putSuccess(JSONObject json, boolean value) { json.put("success", value); }

    public static void putDataBaseError(JSONObject json) { json.put("message", "database error"); }

    public static void putProductKindList(JSONObject json) { json.put("productKindList", ProductKindList.productKindList); }

    public static void putIsLegal(JSONObject json, boolean value) { json.put("isLegal", value); }

    public static void putMessage(JSONObject json, String message) { json.put("message", message); }
}
