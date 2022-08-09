package com.shang.mybatisPlusDemo.car.mapper;

import com.shang.mybatisPlusDemo.car.entity.Car;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 测试表 Mapper 接口
 * </p>
 *
 * @author shang
 * @since 2022-07-14
 */
@Mapper
public interface CarMapper extends BaseMapper<Car> {

}
