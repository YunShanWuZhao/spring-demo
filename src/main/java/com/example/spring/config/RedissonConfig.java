package com.example.spring.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedissonConfig {

    @Value("${spring.redis.url}")
    private String redisUrl;

    @Value("${spring.redis.password}")
    private String password;



    @Bean
    RedissonClient redissonClient(){
        Config config = new Config();
        config.useSingleServer().setAddress(redisUrl).setPassword(password);
        return Redisson.create(config);
    }

    //@Bean
    RedissonClient redissonClient2(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://118.31.185.82:6379").setPassword("tgs.redis.0");
        return Redisson.create(config);
    }

}
