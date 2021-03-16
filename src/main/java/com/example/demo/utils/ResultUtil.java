package com.example.demo.utils;

import com.example.demo.enums.ResultEnum;
import com.example.demo.message.Result;

public class ResultUtil {

    //当正确时返回的值
    public static <T> Result<T> success(T data) {
        return new Result<T>(ResultEnum.SUCCESS.code(), ResultEnum.SUCCESS.msg(), data);
    }

    public static <T> Result<T> success() {
        return success(null);
    }

    //当错误时返回
    public static <T> Result<T> error(int code, String msg) {
        return new Result<T>(code, msg);
    }
}
