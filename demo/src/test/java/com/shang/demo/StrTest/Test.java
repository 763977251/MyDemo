package com.shang.demo.StrTest;

import org.apache.commons.lang3.StringUtils;

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

    @org.junit.jupiter.api.Test
    public void test2(){
//        String str = "123/234/345/456";
        String str = "123";
        int level = StringUtils.countMatches(str, "/");
        System.out.println(level);
        String lastFromOrgPath = getLastFromOrgPath(str);
        System.out.println(lastFromOrgPath);
    }

    private String getLastFromOrgPath(String orgPath) {
        int lastIndex = orgPath.lastIndexOf("/");
        return orgPath.substring(lastIndex+1);
    }

    @org.junit.jupiter.api.Test
    public void test3(){
        String str = "123";
        int lastIndex = str.lastIndexOf("/");
        if (lastIndex < 0){
            System.out.println("0");
            return;
        }
        str = str.substring(0, lastIndex);
        System.out.println(str);
        System.out.println(getLastFromOrgPath(str));
    }

    @org.junit.jupiter.api.Test
    public void test4(){
        String str = "123123dfwfwfASDS$";
        boolean letterDigitOrChinese = isLetterOrDigit(str);
        System.out.println(letterDigitOrChinese);
    }
    public static boolean isLetterOrDigit(String str) {
        String regex = "^[a-z0-9A-Z]+$";
        return str.matches(regex);
    }

    @org.junit.jupiter.api.Test
    public void test33() {

        String str = "/u01/deploy/visitor-api-s01/1.jpg";

        String regex = "/^[a-zA-Z]:[\\\\]((?! )(?![^\\\\/]*\\s+[\\\\/])[\\w -]+[\\\\/])*(?! )(?![^.]*\\s+\\.)[\\w -]+$/";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(str);

        System.out.println(matcher.matches());

    }

}
