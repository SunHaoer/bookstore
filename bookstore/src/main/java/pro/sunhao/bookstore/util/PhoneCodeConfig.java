package pro.sunhao.bookstore.util;

import java.util.Random;

public class PhoneCodeConfig {
    public static String host = "https://chanyoo.market.alicloudapi.com";
    public static String path = "/sendsms";
    public static String method = "GET";
    public static String appcode = "fba4071a97e249b7869aaa569815dc88";

    public static String getPhoneCode(int codeLength) {
        String codes = "qwertyuiopasdfghjklzxcvbnm0123456789";
        StringBuilder outputStr = new StringBuilder("");
        Random random = new Random();
        for (int i = 0; i < codeLength; i++){
            outputStr.append(codes.charAt(random.nextInt(codes.length() - 1)));
        }
        //System.out.println(outputStr);
        return outputStr.toString();
    }

    public static String getPhoneMessageContent(String phoneNum, String phoneCode) {
        return "您的手机号：" + phoneNum + "，验证码：" + phoneCode + "，请及时完成验证，如不是本人操作请忽略。【阿里云市场】";
    }

}
