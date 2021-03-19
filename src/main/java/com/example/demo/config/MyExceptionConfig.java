package com.example.demo.config;

import com.example.demo.enums.ResultEnum;
import com.example.demo.exception.ReworkDemoException;
import com.example.demo.message.Result;
import com.example.demo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

// 全局异常处理配置
@RestControllerAdvice
public class MyExceptionConfig {

    private static final Logger log = LoggerFactory.getLogger(MyExceptionConfig.class);

    //功能描述: 处理自定义异常类
    @ExceptionHandler(value = ReworkDemoException.class)
    <T> Result<T> handleMyException(ReworkDemoException e, HttpServletRequest request) {
        //返回json数据
        log.error("业务异常:{}", e);
        return ResultUtil.error(ResultEnum.INTERNAL_SERVER_ERROR.code(), e.getMsg());
    }

    //捕获全局异常,处理所有不可知的异常,避免直接抛给用户
    @ExceptionHandler(value = Exception.class)
    <T> Result<T> handleException(Exception e, HttpServletRequest request) {
        //返回json数据
        log.error("全局异常:{},{}", e.getMessage(),e);
        return ResultUtil.error(ResultEnum.INTERNAL_SERVER_ERROR.code(), e.getMessage());
    }


}
