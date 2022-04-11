package com.shang.demo;

public class Test4343 {
    public static int show() {
        int result = 0;
        try {
            return result;
        } finally {
            result = 1;
            System.out.println("finally模块被执行");
            System.out.println(result);
        }
    }

    public static void main(String args[]) {
        System.out.println(show());
    }
}
