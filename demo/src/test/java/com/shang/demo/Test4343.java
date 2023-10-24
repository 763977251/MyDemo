package com.shang.demo;

public class Test4343 {

//    public static void main(String args[]) {
//        long maxValue = Long.MAX_VALUE;
//        System.out.println(maxValue);
//        System.out.println(maxValue / 365);
//        System.out.println(maxValue / 365 / 24);
//        System.out.println(maxValue / 365 / 24 / 3600);
//
//        System.out.println(maxValue / (100000000L * 3600 * 24 * 365));
//    }

    public static void main(String[] args) {
        Integer NO = 0;
        if(NO.equals(Integer.parseInt("0"))){
            System.out.println(1);
        } else {
            System.out.println(0);
        }

//        Integer i = null;


//        String s = convertToExcelTitle(16);
//        System.out.println(s);
    }

    public static String convertToExcelTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0){
            columnNumber--;
            sb.append((char) (columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        sb.reverse();
        return sb.toString();
    }
}
