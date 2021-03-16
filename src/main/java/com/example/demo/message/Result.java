package com.example.demo.message;
//自定义全局返回类型
//需要添加get 不然会序列化失败，导致前端报406错误

import java.io.Serializable;

public class Result<T> implements Serializable {

    private static final long serialVersionUID = -8382274421224550908L;

    //状态码
    private int code;
    //信息
    private String message;
    //数据
    private T data;

    public Result() {
    }

    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
