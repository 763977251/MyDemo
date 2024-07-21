package com.shang.demo.StrTest;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class StrTest232 {
    public static void main(String[] args) {
        String str = "00000df0010dsd0";
        str = str.replaceFirst("^0*", "");
        System.out.println(str);

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

    @Test
    public void test111(){
        List<String> list = new ArrayList<>();
        list.add("6.0-3660*2630,29,C,VP,无膜裸包,喷粉");
        list.add("6.0-3660*2630,30,C,VP,无膜裸包,喷粉");
        list.add("6.0-3660*2630,30,A,VP,无膜裸包,喷粉");
        list.add("6.0-3660*2630,30,C");
        list.add("6.0-3660*2631,29,C,VP,无膜裸包,喷粉");
        list.add("6.0-3660*2631,,C,VP,无膜裸包,喷粉");
        list.add("6.0-3660*2630,,C,VP,无膜裸包,喷粉");

        String str = "6.0-3660*2630,,C,VP,,";
        String[] split = str.split(",");
        StringBuffer reg = new StringBuffer();
        String[] fbsArr = { "\\", "$", "(", ")", "*", "+", ".", "[", "]", "?", "^", "{", "}", "|" };
        for (String s : split) {
            if (StringUtils.isEmpty(s)) {
                reg.append(".*,");
            } else {
                for (String key : fbsArr) {
                    if (s.contains(key)) {
                        s = s.replace(key, "\\" + key);
                    }
                }
                reg.append("(");
                reg.append(s);
                reg.append("),");
            }
        }
        String regStr = reg.substring(0, reg.length() - 1) + ".*";
//        String str2 = "(6\\.0-3660\\*2630),.*,(C),(VP).*";
        for (String s : list) {
            if (s.matches(regStr)) {
                System.out.println(s);
            }
        }
    }
}
