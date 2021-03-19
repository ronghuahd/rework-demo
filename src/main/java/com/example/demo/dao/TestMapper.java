package com.example.demo.dao;

import com.example.demo.entity.model.TestDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TestMapper {

    @Select("select id,name,create_time,update_time from test where id=#{id}")
    TestDO findById(@Param("id") int id);

    @Select("select id,name,create_time,update_time from " +
            "test where name like concat('%',#{name},'%')")
    List<TestDO> findByName(@Param("name") String name);

    @Insert("insert into test (name) values (#{name})")
    int insertOne(@Param("name") String name);

    @Update("update test set name=#{name} where id=#{id}")
    void updateNameById(@Param("id")int id,@Param("name")String name);

}
