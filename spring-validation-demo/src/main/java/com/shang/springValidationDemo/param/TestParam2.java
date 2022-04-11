package com.shang.springValidationDemo.param;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

/**
 * 测试请求参数实体类2
 */
@Data
public class TestParam2 {
    /**
     * 姓名
     */
    @NotEmpty(message = "姓名不能为空", groups = {Default.class, Add.class})
    private String name;

    /**
     * 对象类型参数
     */
    @Valid
    @NotNull(message = "对象属性不能为null", groups = {Default.class, Add.class})
    private TestParam testParam;

    public interface Add {
    }
}
