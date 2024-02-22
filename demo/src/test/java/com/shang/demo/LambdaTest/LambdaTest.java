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
        TestUser testUser3 = TestUser.builder().id("6").name("333").build();
        TestUser testUser4 = TestUser.builder().id("4").name("4444").build();
        List<TestUser> testUsers = Arrays.asList(testUser, testUser2, testUser3, testUser4);

        // Collectors.toMap() 必须保证testUsers列表里的TestUser::getId唯一，否则lambda方法报错
        Map<String, TestUser> collect = testUsers.stream().collect(Collectors.toMap(TestUser::getId, s -> s));
        System.out.println(collect);


    }

    @Test
    public void test2(){
        TestUser testUser = TestUser.builder().id("1").name("1").build();
        TestUser testUser2 = TestUser.builder().id("2").name("22").build();
        TestUser testUser3 = TestUser.builder().id("2").name(null).build();
        TestUser testUser4 = TestUser.builder().id("2").name("22").build();
        List<TestUser> testUsers = Arrays.asList(testUser, testUser2, testUser3, testUser4);

        // 字段为null也可以进行分组，默认为"null"字符串
        Map<String, List<TestUser>> collect = testUsers.stream().collect(Collectors.groupingBy(ele -> String.join("_", ele.getId(), ele.getName())));
        System.out.println(collect);
    }
}
