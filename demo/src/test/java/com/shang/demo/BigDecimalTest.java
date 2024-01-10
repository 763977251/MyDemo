package com.shang.demo;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class BigDecimalTest {

    @Test
    public void test() {
        BigDecimal bigDecimal1 = new BigDecimal("0.00001");
        BigDecimal bigDecimal2 = new BigDecimal("-1.1234e-4");

        System.out.println(bigDecimal1.compareTo(bigDecimal2));
    }

    @Test
    public void test2() {
        BigDecimal bigDecimal1 = new BigDecimal("1e5");
        BigDecimal bigDecimal2 = new BigDecimal("100000");

        System.out.println(bigDecimal1.compareTo(bigDecimal2));
    }

    @Test
    public void test3() {
            BigDecimal number = new BigDecimal("123456789.10"); // 原始值为"123456789.00"
            BigDecimal strippedNumber = number.stripTrailingZeros(); // 移除小数点后面的零
            System.out.println(strippedNumber); // 输出结果为 "123456789"
    }
}
