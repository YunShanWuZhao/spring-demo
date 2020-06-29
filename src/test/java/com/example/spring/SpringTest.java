package com.example.spring;

import com.alibaba.fastjson.JSON;
import com.example.spring.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void test(){
        System.out.println(JSON.toJSONString(userMapper.selectById(1)));
    }
}
