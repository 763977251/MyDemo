package com.shang.demo.java17Test;

import lombok.AllArgsConstructor;
import lombok.Data;

// 这里使用lombok减少代码
@Data
@AllArgsConstructor
public class Person {
    private String name;

    private int age;

    private String address;
}