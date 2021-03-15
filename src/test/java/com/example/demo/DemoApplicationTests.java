package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

// 这是junit4的写法 @runwith(springrunner.class)
// 下面是junit5的写法
@ExtendWith(SpringExtension.class)
@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("测试方法运行");
    }

}
