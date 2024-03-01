package com.shang.mybatisPlusDemo.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shang.mybatisPlusDemo.common.JsonResponse;
import com.shang.mybatisPlusDemo.entity.TestTable;
import com.shang.mybatisPlusDemo.service.ITestTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 测试表 前端控制器
 * </p>
 *
 * @author 尚高
 * @since 2021-11-08
 */
@RestController
@RequestMapping
public class TestTableController {
    @Autowired
    protected ITestTableService testTableService;

    @GetMapping
    public Page<TestTable> test(){
        Page<TestTable> page = new Page<>();
        return testTableService.page(page);
    }

    @PostMapping("/test-table/add")
    public int add(@RequestBody TestTable testTable){
        return testTableService.insertOrUpdate(testTable);
    }

    @GetMapping("/test-table/list")
    public JsonResponse<List<TestTable>> list(){
        return new JsonResponse<>(testTableService.list());
    }

    @GetMapping("/test-table/testTransactional")
    public JsonResponse<String> testTransactional(){
        testTableService.testTransactional();
        return JsonResponse.success();
    }

}
