package com.example.spring.design.proxy;

public class TestMain {

    public static void main(String[] args) {
        System.out.println("proxy cat");
        StaticProxy staticProxy = new StaticProxy(new Cat());
        staticProxy.say();
        staticProxy.walk();

        System.out.println("--------------------------");
        StaticProxy staticProxyDog = new StaticProxy(new Dog());
        staticProxyDog.say();
        staticProxyDog.walk();
    }
}
