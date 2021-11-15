package com.shang.demo.LambdaTest;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LambdaTest {
    @Test
    public void test(){
        TestUser testUser = TestUser.builder().id("1").name("1").build();
        TestUser testUser2 = TestUser.builder().id("2").name("22").build();
        TestUser testUser3 = TestUser.builder().id("3").name("333").build();
        TestUser testUser4 = TestUser.builder().id("4").name("4444").build();
        List<TestUser> testUsers = Arrays.asList(testUser, testUser2, testUser3, testUser4);
        Map<String, TestUser> collect = testUsers.stream().collect(Collectors.toMap(TestUser::getId, s -> s));
        System.out.println(collect);


    }
}
