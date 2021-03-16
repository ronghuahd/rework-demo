package com.example.demo.service.impl;

import com.example.demo.entity.Test;
import com.example.demo.mapper.TestMapper;
import com.example.demo.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    @Resource
    private TestMapper testMapper;

    @Override
    public Test findById(long id) {
        return testMapper.findById(id);
    }

    @Override
    public List<Test> findByName(String name) {
        return testMapper.findByName(name);
    }

    @Override
    public int insertOne(String name) {
        return testMapper.insertOne(name);
    }

    @Override
    public void updateNameById(long id, String name) {
        testMapper.updateNameById(id, name);
    }
}
