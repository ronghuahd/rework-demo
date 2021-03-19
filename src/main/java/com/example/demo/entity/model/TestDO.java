package com.example.demo.entity.model;

import lombok.Data;

import java.util.Date;

@Data
public class TestDO {
    private Integer id;
    private String name;
    private Date createTime;
    private Date updateTime;
}
