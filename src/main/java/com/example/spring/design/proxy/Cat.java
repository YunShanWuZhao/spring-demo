package com.example.spring.design.proxy;

public class Cat implements Target {

    @Override
    public void say() {
        System.out.println("miaomiaomiao...");
    }

    @Override
    public void walk() {
        System.out.println("dingdingdongdong...");
    }
}
