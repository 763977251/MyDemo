package com.shang.demo;

public class Test4343 {

    public static void main(String args[]) {
        long maxValue = Long.MAX_VALUE;
        System.out.println(maxValue);
        System.out.println(maxValue / 365);
        System.out.println(maxValue / 365 / 24);
        System.out.println(maxValue / 365 / 24 / 3600);

        System.out.println(maxValue / (100000000L * 3600 * 24 * 365));
    }
}
