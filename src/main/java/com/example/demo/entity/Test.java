package com.example.demo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Test {
    private Long id;
    private String name;
    private Date createTime;
    private Date updateTime;

}
