package com.example.demo.controller;

import com.example.demo.entity.Test;
import com.example.demo.service.TestService;
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
    @GetMapping("/get_name")
    public String getName(String name) {
        log.info("输出name:" + name);
        return "连通成功:" + name;
    }

    @ApiOperation(value = "ping")
    @GetMapping("/ping")
    public String ping() {
        return "连通成功:welcome!";
    }

    @ApiOperation(value = "通过id查询数据")
    @GetMapping("/query_by_id")
    public Test queryById(
            @ApiParam("id") @RequestParam("id") long id) {
        return testService.findById(id);
    }

    @ApiOperation(value = "通过name模糊查询数据")
    @GetMapping("/query_by_name")
    public List<Test> queryByName(
            @ApiParam("name") @RequestParam("name") String name) {
        return testService.findByName(name);
    }

    @ApiOperation(value = "添加数据")
    @PutMapping("/insert")
    public String insert(
            @ApiParam("name") @RequestParam("name") String name) {
        testService.insertOne(name);
        return "ok";
    }

    @ApiOperation(value = "根据id修改数据")
    @PutMapping("/update")
    public String update(
            @ApiParam("id") @RequestParam("id") long id,
            @ApiParam("name") @RequestParam("name") String name) {
        testService.updateNameById(id, name);
        return "ok";
    }


}
