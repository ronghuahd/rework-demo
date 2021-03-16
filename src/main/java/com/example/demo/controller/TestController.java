package com.example.demo.controller;

import com.example.demo.entity.Test;
import com.example.demo.message.Result;
import com.example.demo.service.TestService;
import com.example.demo.utils.ResultUtil;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
@Api(value = "test", tags = "测试连通性")
public class TestController {
    private final Logger log = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private TestService testService;

    @ApiOperation(value = "查询名称")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "name", value = "名称", required = true)})
    @GetMapping(value = "/get_name")
    public Result<String> getName(String name) {
        log.info("输出name:" + name);
        return ResultUtil.success("连通成功:" + name);
    }

    @ApiOperation(value = "ping")
    @GetMapping("/ping")
    public Result<String> ping() {
        //模拟算数异常
        // int a=10/0;
        return ResultUtil.success("连通成功:welcome!");
    }

    @ApiOperation(value = "通过id查询数据")
    @GetMapping("/query_by_id")
    public Result<Test> queryById(
            @ApiParam("id") @RequestParam("id") Long id) {
        return ResultUtil.success(testService.findById(id));
    }

    @ApiOperation(value = "通过name模糊查询数据")
    @GetMapping("/query_by_name")
    public Result<List<Test>> queryByName(
            @ApiParam("name") @RequestParam("name") String name) {
        return ResultUtil.success(testService.findByName(name));
    }

    @ApiOperation(value = "添加数据")
    @PutMapping("/insert")
    public Result<String> insert(
            @ApiParam("name") @RequestParam("name") String name) {
        testService.insertOne(name);
        return ResultUtil.success();
    }

    @ApiOperation(value = "根据id修改数据")
    @PutMapping("/update")
    public Result<String> update(
            @ApiParam("id") @RequestParam("id") Long id,
            @ApiParam("name") @RequestParam("name") String name) {
        testService.updateNameById(id, name);
        return ResultUtil.success();
    }


}
