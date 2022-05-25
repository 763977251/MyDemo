package com.shang.mybatisPlusDemo.service.impl;

import com.shang.mybatisPlusDemo.entity.TestTable;
import com.shang.mybatisPlusDemo.mapper.TestTableMapper;
import com.shang.mybatisPlusDemo.service.ITestTableService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 测试表 服务实现类
 * </p>
 *
 * @author 尚高
 * @since 2021-11-08
 */
@Service
public class TestTableServiceImpl extends ServiceImpl<TestTableMapper, TestTable> implements ITestTableService {
    public void test(){
        baseMapper.selectById(1L);
    }

    @Override
    public int insertOrUpdate(TestTable testTable) {
        return baseMapper.insertOrUpdate(testTable);
    }
}
