package com.example.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test")
@Api("test")
public class FirstController {
    private final Logger log = LoggerFactory.getLogger(FirstController.class);

    @ApiOperation(value = "查询名称", tags = "查询名称")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "name", value = "名称", required = true)})
    @GetMapping("/get_name")
    public String getName(String name) {
        log.info("输出name:" + name);
        return "返回值:" + name;
    }
}
