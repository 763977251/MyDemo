package com.shang.mybatisPlusDemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shang.mybatisPlusDemo.entity.TestTable;
import com.shang.mybatisPlusDemo.mapper.TestTableMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 测试表 服务实现类
 * </p>
 *
 * @author 尚高
 * @since 2021-11-08
 */
@Service
public class TestService extends ServiceImpl<TestTableMapper, TestTable> {

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void updateDelFlag(Long id) {
        if (id == 4L) {
            throw new RuntimeException("报错测试");
        }
        TestTable update = TestTable.builder().id(id).deleted(1).build();
        baseMapper.updateById(update);
    }
}
