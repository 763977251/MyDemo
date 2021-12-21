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
}
