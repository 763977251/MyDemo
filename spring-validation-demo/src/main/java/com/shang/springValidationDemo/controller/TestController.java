package com.shang.springValidationDemo.controller;

import com.shang.springValidationDemo.exception.ConditionException;
import com.shang.springValidationDemo.param.TestParam;
import com.shang.springValidationDemo.param.TestParam2;
import com.shang.springValidationDemo.response.JsonResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Validated
@RestController
public class TestController {

    /**
     * 测试全局异常是否生效
     */
    @GetMapping("/testGlobalException")
    public JsonResponse<String> testGlobalException() {
        throw new ConditionException("发生了异常");
    }

    /**
     * 测试get请求的参数校验功能
     * @param name 姓名
     * @param age 年龄
     */
    @Validated
    @GetMapping("/testParam1")
    public JsonResponse<String> testParam1(@NotEmpty(message = "姓名不能为空") String name,
                                           @NotNull(message = "年龄不能为空") Integer age) {
        return JsonResponse.success();
    }

    /**
     * 测试get请求的参数校验功能2
     * 测试使用对象接收参数时的参数校验
     */
    @GetMapping("/testParam2")
    public JsonResponse<TestParam> testParam2(@Valid TestParam testParam) {
        return new JsonResponse<>(testParam);
    }

    /**
     * 测试post请求的参数校验功能
     */
    @PostMapping("/testParam3")
    public JsonResponse<String> testParam3(@NotEmpty(message = "姓名不能为空1") String name,
                                           @NotNull(message = "年龄不能为空") Integer age,
                                           @RequestParam("file") MultipartFile file) {
        return new JsonResponse<>(name);
    }

    /**
     * 测试post请求的参数校验功能2
     * 测试使用对象接收参数时的参数校验
     */
    @PostMapping("/testParam4")
    public JsonResponse<TestParam> testParam4(@Valid TestParam testParam) {
        return new JsonResponse<>(testParam);
    }

    /**
     * 测试post请求接受json格式参数校验功能
     * // @Valid 不仅校验当前对象的属性，并且对象类型的属性使用注解@Valid也会校验
     */
    @PostMapping("/testParam5")
    public JsonResponse<TestParam2> testParam5(@Valid @RequestBody TestParam2 testParam2) {
        return new JsonResponse<>(testParam2);
    }

    /**
     * 测试post请求接受json格式参数校验功能2
     * // @Validated 不仅校验当前对象的属性，并且对象类型的属性使用注解@Valid也会校验
     */
    @PostMapping("/testParam6")
    public JsonResponse<TestParam2> testParam6(@Validated @RequestBody TestParam2 testParam2) {
        return new JsonResponse<>(testParam2);
    }

    /**
     * 测试post请求接受json格式参数校验功能3
     * 检验不通的class类型
     */
    @PostMapping("/testParam7")
    public JsonResponse<TestParam2> testParam7(@Validated(TestParam2.Add.class) @RequestBody TestParam2 testParam2) {
        return new JsonResponse<>(testParam2);
    }
}
