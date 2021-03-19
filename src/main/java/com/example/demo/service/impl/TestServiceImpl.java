package com.example.demo.service.impl;

import com.example.demo.entity.model.TestDO;
import com.example.demo.dao.TestMapper;
import com.example.demo.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    @Resource
    private TestMapper testMapper;

    @Override
    public TestDO findById(int id) {
        return testMapper.findById(id);
    }

    @Override
    public List<TestDO> findByName(String name) {
        return testMapper.findByName(name);
    }

    @Override
    public int insertOne(String name) {
        return testMapper.insertOne(name);
    }

    @Override
    public void updateNameById(int id, String name) {
        testMapper.updateNameById(id, name);
    }
}
