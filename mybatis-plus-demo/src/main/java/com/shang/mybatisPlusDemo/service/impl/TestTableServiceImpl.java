package com.shang.mybatisPlusDemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shang.mybatisPlusDemo.entity.TestTable;
import com.shang.mybatisPlusDemo.mapper.TestTableMapper;
import com.shang.mybatisPlusDemo.service.ITestTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 测试表 服务实现类
 * </p>
 *
 * @author 尚高
 * @since 2021-11-08
 */
@Service
@RequiredArgsConstructor
public class TestTableServiceImpl extends ServiceImpl<TestTableMapper, TestTable> implements ITestTableService {

    public final TestService testService;

    public void test(){
        baseMapper.selectById(1L);
    }

    @Override
    public int insertOrUpdate(TestTable testTable) {
        return baseMapper.insertOrUpdate(testTable);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void testTransactional() {
        List<TestTable> list = this.list();
        for (TestTable testTable : list) {
//            this.updateDelFlag(testTable.getId()); // 自调用自方法事务不生效
            testService.updateDelFlag(testTable.getId()); // 事务不生效
        }
        throw new RuntimeException("报错测试2");
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void updateDelFlag(Long id) {
        if (id == 4L) {
            throw new RuntimeException("报错测试");
        }
        TestTable update = TestTable.builder().id(id).deleted(1).build();
        baseMapper.updateById(update);
    }
}
