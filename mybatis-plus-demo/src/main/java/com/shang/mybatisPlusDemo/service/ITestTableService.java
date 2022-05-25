package com.shang.mybatisPlusDemo.service;

import com.shang.mybatisPlusDemo.entity.TestTable;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 测试表 服务类
 * </p>
 *
 * @author 尚高
 * @since 2021-11-08
 */
public interface ITestTableService extends IService<TestTable> {

    int insertOrUpdate(TestTable testTable);
}
