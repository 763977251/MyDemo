package com.shang.demo.StrTest;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class StrTest11 {
    public static void main(String[] args) {
        String fileName = "23r22jpG";
        // 获取文件后缀名
        if (StringUtils.isEmpty(fileName)){
//            throw new ConditionException("未获取到文件名");
            System.out.println("error");
        }
        int lastIndexOf = fileName.lastIndexOf(".");
        String substring = fileName.substring(lastIndexOf).toLowerCase();
        System.out.println(substring);
        List<String> suffixs = Arrays.asList(".jpg", ".png", ".jpeg");
        if (suffixs.contains(substring)){
            System.out.println("11");
        } else {
            System.out.println("22");
        }
    }

    @Test
    public void test(){
        String orgPathId = "1/1179679/9760774/767197196/97588266/961000953";
        System.out.println(Arrays.asList(orgPathId.split("/")));
    }
}
