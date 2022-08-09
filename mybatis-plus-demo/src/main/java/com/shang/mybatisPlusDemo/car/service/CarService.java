package com.shang.mybatisPlusDemo.car.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shang.mybatisPlusDemo.car.entity.Car;
import com.shang.mybatisPlusDemo.car.mapper.CarMapper;
import com.shang.mybatisPlusDemo.common.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 测试表 服务实现类
 *
 * @author shang
 * @since 2022-07-14
 */
@Service
public class CarService extends ServiceImpl<CarMapper, Car> {

    @Autowired
    private CarMapper mapper;

    /**
    * 测试表 添加信息
    */
    public int add(Car entity) {
        return mapper.insert(entity);
    }

    /**
    * 测试表 根据id删除信息
    */
    public int delete(Long id){
        return mapper.deleteById(id);
    }

    /**
    * 测试表 编辑信息
    */
    public int update(Car entity) {
        return mapper.updateById(entity);
    }

    /**
    * 测试表 分页获取列表信息
    */
    public PageResult<Car> selectPage(Integer pageNo, Integer pageSize) {
        Page<Car> page = new Page<>(pageNo,pageSize);
        LambdaQueryWrapper<Car> queryWrapper = new LambdaQueryWrapper<>();
        this.page(page, queryWrapper);
        return new PageResult<>(Math.toIntExact(page.getTotal()),page.getRecords());
    }

    /**
    * 测试表 根据id查询详情
    */
    public Car detail(Long id){
        return this.getById(id);
    }

}
