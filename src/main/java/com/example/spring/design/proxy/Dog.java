package com.example.spring.design.proxy;

public class Dog implements Target {

    @Override
    public void say() {
        System.out.println("wangwangwang...");
    }

    @Override
    public void walk() {
        System.out.println("bangbangbang...");
    }
}
