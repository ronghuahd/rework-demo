package com.example.demo.exception;

//自定义异常，可以通过配置统一异常配置，捕获异常返回
public class ReworkDemoException extends RuntimeException {
    private static final long serialVersionUID = 8872293085124112010L;

    private int code;
    private String msg;

    public ReworkDemoException(String message, int code, String msg) {
        super(message);
        this.code = code;
        this.msg = msg;
    }

    public ReworkDemoException() {
        super();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
