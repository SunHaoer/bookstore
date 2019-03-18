package pro.sunhao.bookstore.util;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonAlias;

public class OperateJson {

    public static void putParameterNull(JSONObject outputJson) {
        outputJson.put("message", "parameter is null");
    }

    public static void putParamterError(JSONObject outputJson) {
        outputJson.put("message", "parameter it not leagal");
    }

    public static void putSuccess(JSONObject outputJson, boolean value) {

        outputJson.put("success", value);
    }

    public static void putDataBaseError(JSONObject outputJson) {

        outputJson.put("message", "database error");
    }
}
