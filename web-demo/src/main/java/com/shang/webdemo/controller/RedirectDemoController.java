package com.shang.webdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class RedirectDemoController {

    @GetMapping("/redirectDemo")
    public void redirectDemo(HttpServletResponse response) throws IOException {
        Cookie cookie = new Cookie("zpark-ut","12345678");
        response.addCookie(cookie);
        String new_url = "http://sub.a.com";
        String html = "<script type='text/javascript'>location.href='"+new_url+"';</script>";
        response.getWriter().print(html);
    }
}
