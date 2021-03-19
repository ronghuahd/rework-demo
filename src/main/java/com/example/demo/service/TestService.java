package com.example.demo.service;

import com.example.demo.entity.model.TestDO;

import java.util.List;


public interface TestService {

    //查询数据
    TestDO findById(int id);

    List<TestDO> findByName(String name);

    int insertOne(String name);

    void updateNameById(int id, String name);
}
