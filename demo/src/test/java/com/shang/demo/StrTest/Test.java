package com.shang.demo.StrTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String name = "尚高1";
        System.out.println(name.matches("[0-9]+"));
        Pattern p = Pattern.compile(".*\\d+.*");
        Matcher m = p.matcher(name);
        System.out.println(m.matches());
    }

    @org.junit.jupiter.api.Test
    public void test1(){
        String visitePlace = "字符串字符串字符串字符串字符串字符串1" + "(" + "字符串字符串" + ")";
        if (visitePlace.length()>20){
            visitePlace = visitePlace.substring(0,visitePlace.lastIndexOf("("));
        }
        System.out.println(visitePlace);
    }
}
