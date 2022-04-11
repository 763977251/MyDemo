package com.shang.springValidationDemo.param;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

/**
 * 测试请求参数实体类
 */
@Data
public class TestParam {

    /**
     * 姓名
     */
    @NotEmpty(message = "姓名不能为空", groups = {Default.class, TestParam2.Add.class})
    private String name;

    /**
     * 年龄
     */
    @NotNull(message = "年龄不能为空")
    private Integer age;
}
