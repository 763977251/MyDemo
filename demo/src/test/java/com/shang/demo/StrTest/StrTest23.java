package com.shang.demo.StrTest;

import org.apache.commons.lang3.StringUtils;

public class StrTest23 {
    public static void main(String[] args) {
        String str = "1e5";
        boolean b = checkStrIsNumber(str);
        System.out.println(b);
    }
    /**
     * 校验是数字（包括科学计数法格式的数字）
     */
    public static boolean checkStrIsNumber(String value) {
        if (StringUtils.isEmpty(value)) {
            return false;
        }
        return value.matches("(\\s)*([+-])?(([0-9]*\\.)?([0-9]+)|([0-9]+)(\\.[0-9]*)?)([eE][\\+-]?[0-9]+)?(\\s)*");
    }
}
