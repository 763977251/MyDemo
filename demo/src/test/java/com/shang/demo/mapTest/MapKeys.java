package com.shang.demo.mapTest;

import java.util.Map;

/**
 * 测试获取Map的所有key
 */
public class MapKeys {
    public static void main(String[] args) {
        // 获取map的所有key的方法
        // 1. map.keySet()
        Map<String, Object> map = Map.of("a", "b", "c", "d");
        System.out.println(map.keySet());
        // 2. map.entrySet()
        System.out.println(map.entrySet());
        // 3. map.forEach()
        map.forEach((k, v) -> System.out.println(k));
        // 4. map.stream()
        map.entrySet().stream().forEach(e -> System.out.println(e.getKey()));
        // 5. map.keySet().stream()
        map.keySet().stream().forEach(k -> System.out.println(k));
        // 6. map.keySet().iterator()
        map.keySet().iterator().forEachRemaining(k -> System.out.println(k));
    }
}
