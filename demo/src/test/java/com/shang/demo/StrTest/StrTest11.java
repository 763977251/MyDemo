package com.shang.demo.StrTest;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    @Test
    public void test2221(){
        LocalDate localDate = LocalDate.now();
        int monthValue = localDate.getMonthValue();
        System.out.println(StringUtils.leftPad(String.valueOf(monthValue),2,"0"));
    }


    @Test
    public void test22(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate parse = LocalDate.parse(null, dtf);
        System.out.println(parse.toString());
    }


    @Test
    public void test2(){
        String orgPathId = "sss,十四说四十,,22 1、234、12323,w3r34";
        String[] split = orgPathId.split("[,、]");
        System.out.println(Arrays.asList(split));
    }
    @Test
    public void test3(){
        String orgPathId = "1122-36-23-000098-34";
//        String orgPathId = "11223623000098";
        System.out.println(orgPathId.substring(0,orgPathId.lastIndexOf("-")+1));
        System.out.println(orgPathId.substring(0,orgPathId.length() - 1));
    }
}
