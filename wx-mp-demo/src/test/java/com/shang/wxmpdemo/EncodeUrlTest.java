package com.shang.wxmpdemo;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class EncodeUrlTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String encode = URLEncoder.encode("http://e23947060n.wicp.vip/testIndex", StandardCharsets.UTF_8);
        System.out.println(encode);
        String decode = URLDecoder.decode(encode, StandardCharsets.UTF_8);
        System.out.println(decode);
    }
}
