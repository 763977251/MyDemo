package com.shang.mybatisPlusDemo.car.controller;

import com.shang.mybatisPlusDemo.car.entity.Car;
import com.shang.mybatisPlusDemo.car.service.CarService;
import com.shang.mybatisPlusDemo.common.JsonResponse;
import com.shang.mybatisPlusDemo.common.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 测试表 前端控制器
 *
 * @author shang
 * @since 2022-07-14
 */
@RestController
public class CarController {

    @Autowired
    private CarService service;

    /**
    * 测试表 添加信息
    */
    @PostMapping("/car/add")
    public JsonResponse add(@RequestBody Car entity){
        int n = service.add(entity);
        if(n>0){
            return JsonResponse.success();
        }else{
            return JsonResponse.fail("添加失败");
        }
    }

    /**
    * 测试表 根据id删除信息
    */
    @DeleteMapping("/car/delete")
    public JsonResponse delete(@RequestParam Long id){
        int n = service.delete(id);
        if(n>0){
            return JsonResponse.success();
        }else{
            return JsonResponse.fail("删除失败");
        }
    }

    /**
    * 测试表 编辑信息
    */
    @PutMapping("/car/update")
    public JsonResponse update(@RequestBody Car entity){
        int n = service.update(entity);
        if(n>0){
            return JsonResponse.success();
        }else{
            return JsonResponse.fail("更新失败");
        }
    }

    /**
    * 测试表 分页列表
    */
    @GetMapping(value = "/car/page")
    public JsonResponse<PageResult<Car>> page(@RequestParam Integer pageNo, @RequestParam Integer pageSize){
        PageResult<Car> pageInfo = service.selectPage(pageNo,pageSize);
        return new JsonResponse<>(pageInfo);
    }

    /**
    * 测试表 根据id查询详情
    */
    @GetMapping(value = "/car/detail")
    public JsonResponse<Car> detail(@RequestParam Long id){
        return new JsonResponse<>(service.detail(id));
    }

    /**
     * 测试表 根据id查询详情
     */
    @GetMapping(value = "/car/list")
    public JsonResponse<List<Car>> list(){
        return new JsonResponse<>(service.list());
    }

}
