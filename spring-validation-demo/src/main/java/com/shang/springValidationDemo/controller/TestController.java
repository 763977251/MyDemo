package com.shang.springValidationDemo.controller;

import com.shang.springValidationDemo.exception.ConditionException;
import com.shang.springValidationDemo.param.TestParam;
import com.shang.springValidationDemo.param.TestParam2;
import com.shang.springValidationDemo.response.JsonResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Validated
@RestController
public class TestController {

    @GetMapping("/testGlobalException")
    public JsonResponse<String> testGlobalException() {
        throw new ConditionException("发生了异常");
    }

    /**
     * 测试参数校验1
     * @param name 姓名
     * @param age 年龄
     */
    @GetMapping("/testParam1")
    public JsonResponse<String> testParam1(@NotEmpty(message = "姓名不能为空") String name,
                                           @NotNull(message = "年龄不能为空") Integer age) {
        return JsonResponse.success();
    }

    /**
     * 测试参数校验2
     */
    @GetMapping("/testParam2")
    public JsonResponse<TestParam> testParam2(@Valid TestParam testParam) {
        return new JsonResponse<>(testParam);
    }

    /**
     * 测试参数校验3
     */
    @PostMapping("/testParam3")
    public JsonResponse<String> testParam3(@NotEmpty(message = "姓名不能为空") String name,
                                              @NotNull(message = "年龄不能为空") Integer age) {
        return new JsonResponse<>(name);
    }

    /**
     * 测试参数校验4
     */
    @PostMapping("/testParam4")
    public JsonResponse<TestParam> testParam4(@Valid TestParam testParam) {
        return new JsonResponse<>(testParam);
    }

    /**
     * 测试参数校验5
     */
    @PostMapping("/testParam5")
    public JsonResponse<TestParam2> testParam5(@Valid @RequestBody TestParam2 testParam2) {
        return new JsonResponse<>(testParam2);
    }

    /**
     * 测试参数校验6
     */
    @PostMapping("/testParam6")
    public JsonResponse<TestParam2> testParam6(@Validated @RequestBody TestParam2 testParam2) {
        return new JsonResponse<>(testParam2);
    }

    /**
     * 测试参数校验7
     */
    @PostMapping("/testParam7")
    public JsonResponse<TestParam2> testParam7(@Validated(TestParam2.Add.class) @RequestBody TestParam2 testParam2) {
        return new JsonResponse<>(testParam2);
    }
}
