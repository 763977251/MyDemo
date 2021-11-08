package com.shang.mybatisPlusDemo.mapper;

import com.shang.mybatisPlusDemo.entity.TestTable;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 测试表 Mapper 接口
 * </p>
 *
 * @author 尚高
 * @since 2021-11-08
 */
@Mapper
public interface TestTableMapper extends BaseMapper<TestTable> {

}
