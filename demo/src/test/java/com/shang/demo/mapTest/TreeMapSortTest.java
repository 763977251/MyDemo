package com.shang.demo.mapTest;

import java.util.Map;
import java.util.TreeMap;

/**
 * @Author 10699518
 * @Description: TODO
 */
public class TreeMapSortTest {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1,"1");
        map.put(4,"4");
        map.put(3,"3");
        map.put(2,"2");
        map.put(-10,"-10");
        map.put(200000,"1");
        map.put(10000,"1");
        map.put(100,"1");
        map.put(11,"1");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey());
        }
    }
}
