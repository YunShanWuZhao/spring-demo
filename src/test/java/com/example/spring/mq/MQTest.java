package com.example.spring.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@SpringBootTest
public class MQTest {


    @Autowired
    ConnectionFactory connectionFactory;

    private static final String EXCHANGE_NAME = "strive_exchange";
    private static final String QUEUE_NAME = "strive_queue";
    private static final String ROUTING_KEY_NAME = "strive.12";


    @Test
    public void testPublish() throws IOException, TimeoutException {
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "topic");
        for (int i = 0; i < 10; i++) {
            String message = "这是条topic消息:" + i;
            channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY_NAME, null, message.getBytes());
            System.out.println("发送消息:" + message);
        }
        channel.close();
        connection.close();
    }

    @Test
    public void testReceive() throws IOException, TimeoutException, InterruptedException {
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "topic");
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "strive.*");
        channel.basicConsume(QUEUE_NAME, true, new StriveConsumer(channel));
        Thread.sleep(100000);
    }

    @Test
    public void testReceive2() throws IOException, TimeoutException, InterruptedException {
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "topic");
        channel.queueDeclare(QUEUE_NAME+"2", false, false, false, null);
        channel.queueBind(QUEUE_NAME+"2", EXCHANGE_NAME, "strive.#");
        channel.basicConsume(QUEUE_NAME+"2", true, new StriveConsumer(channel));
        Thread.sleep(100000);
    }
}
