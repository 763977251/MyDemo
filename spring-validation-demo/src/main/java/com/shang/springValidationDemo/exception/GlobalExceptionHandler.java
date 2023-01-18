package com.shang.springValidationDemo.exception;

import com.shang.springValidationDemo.response.JsonResponse;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(value = ConditionException.class)
    public JsonResponse<String> bizExceptionHandler(ConditionException e) {
        return JsonResponse.fail(e.getTip());
    }

    /**
     * 处理参数绑定异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public JsonResponse<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();
        List<FieldError> errorList = result.getFieldErrors();
        List<String> errorMessages = errorList.stream().map(x -> String.format("%s:%s", x.getField(), x.getDefaultMessage())).toList();
        return JsonResponse.fail(errorMessages.toString());
    }

    /**
     * 处理其它异常
     */
    @ExceptionHandler(value = Exception.class)
    public JsonResponse<String> exceptionHandler(Exception e) {
        return JsonResponse.fail(e.getMessage());
    }
}
