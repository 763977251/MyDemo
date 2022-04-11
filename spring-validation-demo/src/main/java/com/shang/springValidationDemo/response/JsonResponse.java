package com.shang.springValidationDemo.response;

public class JsonResponse<T> {
    private String code;
    private String msg;
    private T data;

    public JsonResponse(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public JsonResponse() {
        this((String)null, (String)null, (T) null);
    }

    public JsonResponse(T data) {
        this("0", "success", data);
    }

    public JsonResponse(String code, String msg) {
        this(code, msg, (T)null);
    }

    public boolean isSuccess() {
        return "0".equals(this.code);
    }

    public static JsonResponse<String> success() {
        return new JsonResponse((Object)null);
    }

    public static JsonResponse<String> success(String data) {
        return new JsonResponse(data);
    }

    public static JsonResponse<String> fail() {
        return new JsonResponse("1", "fail");
    }

    public static JsonResponse<String> fail(String msg) {
        return new JsonResponse("1", msg);
    }

    public static JsonResponse<String> fail(String code, String msg) {
        return new JsonResponse(code, msg);
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
