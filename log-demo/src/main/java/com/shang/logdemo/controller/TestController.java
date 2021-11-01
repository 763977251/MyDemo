package com.shang.logdemo.controller;

import com.shang.logdemo.entity.TestEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试Controller
 */
@RestController
public class TestController {

    private final static Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/test1")
    public void test1(){
        LOGGER.info("/test1");
    }

    @GetMapping("/test2")
    public String test2(@RequestParam String name){
        LOGGER.info("/test2 {}",name);
        return name;
    }

    @GetMapping("/test3")
    public TestEntity test3(TestEntity testEntity){
        LOGGER.info("/test3 {}",testEntity);
        return testEntity;
    }

    @GetMapping("/test4")
    public TestEntity test4(@RequestBody TestEntity testEntity){
        LOGGER.info("/test4 {}",testEntity);
        return testEntity;
    }
}
