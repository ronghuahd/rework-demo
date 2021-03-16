package com.example.demo.mapper;

import com.example.demo.entity.Test;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TestMapper {

    @Select("select id,name,create_time,update_time from test where id=#{id}")
    Test findById(@Param("id") long id);

    @Select("select id,name,create_time,update_time from " +
            "test where name like concat('%',#{name},'%')")
    List<Test> findByName(@Param("name") String name);

    @Insert("insert into test (name) values (#{name})")
    int insertOne(@Param("name") String name);

    @Update("update test set name=#{name} where id=#{id}")
    void updateNameById(@Param("id")long id,@Param("name")String name);

}
