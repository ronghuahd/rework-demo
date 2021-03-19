package com.example.demo;

import com.example.demo.dao.TestMapper;
import com.example.demo.entity.model.TestDO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

// 这是junit4的写法 @runwith(springrunner.class)
// 下面是junit5的写法
@ExtendWith(SpringExtension.class)
@SpringBootTest
class DemoApplicationTests {

    private static final Logger log= LoggerFactory.getLogger(DemoApplicationTests.class);

    @Resource
    private SqlSessionFactory SqlSessionFactory;

    // @Resource
    // private TestMapper TestMapper;

    @Test
    void contextLoads() {
        System.out.println("测试方法运行");
        System.out.println("sql一级缓存范围："+SqlSessionFactory.getConfiguration().getLocalCacheScope());
        System.out.println("二级缓存是否开启："+SqlSessionFactory.getConfiguration().isCacheEnabled());
        //手动开启一个sqlsession，用于测试缓存
        SqlSession sqlSession = SqlSessionFactory.openSession();
        TestMapper mapper = sqlSession.getMapper(TestMapper.class);
        for (int i=0;i<5;i++){
            TestDO byId = mapper.findById(3);
            log.info("信息:{}",byId);
        }
    }

    // for (int i=0;i<5;i++){
    //     TestDO byId = TestMapper.findById(3);
    //     log.info("信息:{}",byId);
    //     //这里缓存失效时因为每次开启不同sqlsession导致的。
    // }

}
