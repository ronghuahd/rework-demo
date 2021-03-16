package com.example.demo.service;

import com.example.demo.entity.Test;

import java.util.List;


public interface TestService {

    //查询数据
    Test findById(long id);

    List<Test> findByName(String name);

    int insertOne(String name);

    void updateNameById(long id, String name);
}
