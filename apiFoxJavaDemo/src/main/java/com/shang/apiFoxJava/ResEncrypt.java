package com.shang.apiFoxJava;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * 对传入的值进行res加密
 */
public class ResEncrypt {
    public static void main(String[] args) {
        // rsa公钥
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC85RNGZlCl/xRtNUrPkngVvru2UzbcZUoXN0BK2XlU3OkJqcv3oe7CuRv0LgyZw8hxAhBS8716f2vdHPe9ge1bYf6Okeci7zrZGcUl700+RKlNgSOcWzx5cab1Jqj+7DzDBUCAGYY5UGH/tAaVkBjhpxaW2f5eFwyLfvE/uDQnCwIDAQAB";
        // rsa私钥
        String privateKey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBALzlE0ZmUKX/FG01Ss+SeBW+u7ZTNtxlShc3QErZeVTc6Qmpy/eh7sK5G/QuDJnDyHECEFLzvXp/a90c972B7Vth/o6R5yLvOtkZxSXvTT5EqU2BI5xbPHlxpvUmqP7sPMMFQIAZhjlQYf+0BpWQGOGnFpbZ/l4XDIt+8T+4NCcLAgMBAAECgYA8mANR3vpZ9XR4/9JquaJ530BZ4WHE210kC149ZHvOZDsBFY3PdwufPUAhWTBDlxFSZwYThgqvI/bW7DbwfKBF1d90cfSFiDfxKjueFW2nDPdRjcdIkMaRrzBl3mtp8eRgTVQjrOz2eg8G7f8ZT7d14QSkaYIwFwMM8BpmZ5XRYQJBAOi0+dyN3U1bQotXcyeSqgjxuMypxHPyypEasgP+sLnpPwhs2I98baw2uBOlZYia5ITZqs61Ah8NuFT09522B9sCQQDPzW5biu/GQ9y4Clp4lKQzv68838MH+DmBMA5mAFtbOa986aiSz2nScr9gTZ1958npLoX/cW1LW7/M7HUWBVyRAkAbP6XKV6pENp1yJ4lKZvgWGAflnzNryFBD8XZK1XXoLxG8cNJi6tUEx1uCoWlkN47up3ZCwhs/e6HMAOtFwlzlAkAf3O8cCEzFyOgSLDw9GwWmjbDQE7tzAGPI5FaA23MmpMy8yZM4l6cxRrkDikMo6B60q5aOWZUZpgLd6C/35XCRAkAo+7Sj04R7B3dBmTNtPr9b6ZgzSk9MW1t8NcCiGq5ihjsYuShDUGcLnn//bFWrlwvGrpyEohM+81AMbYQM7jjQ";

        // 需要加密的数据
        // apiFox官方文档说明：脚本pm.execute('cn.apifox.Base64EncodeDemo.jar', ['abc','bcd'])，实际执行命令为java -jar cn.apifox.Base64EncodeDemo.jar abc bcd
        // 此处取的值就是执行jar包时传入的参数，可以根据需要传入其他值
        String param = args[0];
        try {
            String encrypt = CreateSecretKey.encrypt(param, publicKey);
            // java -jar执行后获取到的结果，相当于输出了，所以前面不要输出没用的东西
            // 使用json字符串形式输出，在apiFox脚本里可以方便解析，也方便返回多个需要的值
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("encrypt",encrypt);
            System.out.println(JSON.toJSONString(resultMap));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
