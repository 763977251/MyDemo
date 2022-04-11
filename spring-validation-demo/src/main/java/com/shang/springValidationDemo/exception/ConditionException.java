package com.shang.springValidationDemo.exception;

/**
 * 自定义异常
 */
public class ConditionException extends RuntimeException {
    private String code;
    private String tip;

    public ConditionException(String code, String tip, String msg) {
        super(msg);
        this.tip = tip;
        this.code = code;
    }

    public ConditionException(String tip, String msg) {
        this("1", tip, msg);
    }

    public ConditionException(String tip) {
        this("1", tip, tip);
    }

    public String getCode() {
        return this.code;
    }

    public String getTip() {
        return this.tip;
    }
}
