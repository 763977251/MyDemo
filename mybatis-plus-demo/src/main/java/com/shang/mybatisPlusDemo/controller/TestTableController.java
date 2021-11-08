package com.shang.mybatisPlusDemo.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shang.mybatisPlusDemo.entity.TestTable;
import com.shang.mybatisPlusDemo.service.ITestTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 测试表 前端控制器
 * </p>
 *
 * @author 尚高
 * @since 2021-11-08
 */
@RestController
@RequestMapping("/test-table")
public class TestTableController {
    @Autowired
    protected ITestTableService testTableService;

    @GetMapping
    public Page<TestTable> test(){
        Page<TestTable> page = new Page<>();
        return testTableService.page(page);
    }

}
