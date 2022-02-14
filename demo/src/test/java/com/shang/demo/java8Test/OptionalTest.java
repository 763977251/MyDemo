package com.shang.demo.java8Test;

import org.junit.jupiter.api.Test;

import java.util.Optional;

public class OptionalTest {

    @Test
    public void test(){
        User user = new User();
        user = Optional.ofNullable(user).orElse(createUser());
        System.out.println(user);
        user = Optional.ofNullable(user).orElseGet(() -> createUser());
        System.out.println(user);
    }

    private User createUser() {
        System.out.println("创建用户");
        User user = new User();
        user.setName("shang");
        return user;
    }
}
