package com.shang.springsecuritydemo.controller;

import com.shang.springsecuritydemo.common.entity.JsonResult;
import com.shang.springsecuritydemo.entity.SysUser;
import com.shang.springsecuritydemo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    SysUserService sysUserService;

    @GetMapping("/getUser")
    public JsonResult getUser() {
        List<SysUser> users = sysUserService.queryAllByLimit(0, 100);
        return JsonResult.success(users);
    }

    @GetMapping("/test")
    public JsonResult test() {
        return JsonResult.success("hello world");
    }
}
