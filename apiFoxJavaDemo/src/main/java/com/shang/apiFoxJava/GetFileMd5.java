package com.shang.apiFoxJava;

import cn.hutool.crypto.digest.MD5;

import java.io.File;

public class GetFileMd5 {
    public static void main(String[] args) {
        String fileSrc = args[0];
//        String fileSrc = "D:\\1108176.jpg";
        MD5 md5 = MD5.create();
        String hex = md5.digestHex(new File(fileSrc));
        System.out.print(hex);
    }
}
