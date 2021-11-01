package com.shang.logdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String test2(String name){
        LOGGER.info("/test2 {}",name);
        return name;
    }
}
