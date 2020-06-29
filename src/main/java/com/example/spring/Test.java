package com.example.spring;

import org.springframework.web.client.RestTemplate;

public class Test {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String resp = restTemplate.getForObject("http://www.baidu.com", String.class);
        System.out.println("resp:"+resp);
    }
}
