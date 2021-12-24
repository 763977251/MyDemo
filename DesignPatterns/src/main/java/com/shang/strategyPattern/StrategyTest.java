package com.shang.strategyPattern;

import org.junit.jupiter.api.Test;

public class StrategyTest {
    @Test
    public void test() {
        String exp = "2+8";
        ICalculator cal = new Plus();
        int result = cal.calculate(exp);
        System.out.println(result);
    }
}
