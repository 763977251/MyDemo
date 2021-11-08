package com.shang.wxmpdemo.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestWebController {

    @GetMapping("/testIndex")
    public String testIndex(){
        return "index";
    }
}
