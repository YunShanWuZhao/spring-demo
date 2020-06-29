package com.example.spring.mq;

import com.rabbitmq.client.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {

    @Bean
    public ConnectionFactory initConnectionFactory() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("47.102.223.168");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("liweiHost");
        connectionFactory.setUsername("liwei");
        connectionFactory.setPassword("272313");
        return connectionFactory;
    }
}
