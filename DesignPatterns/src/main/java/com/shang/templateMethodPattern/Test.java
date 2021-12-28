package com.shang.templateMethodPattern;

public class Test {

    @org.junit.jupiter.api.Test
    public void test1() {
        String exp = "8+8";
        AbstractCalculator cal = new Plus();
        int result = cal.calculate(exp, "\\+");
        System.out.println(result);
    }
}
