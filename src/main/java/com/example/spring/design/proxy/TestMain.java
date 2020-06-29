package com.example.spring.design.proxy;

public class TestMain {

    public ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();

    public ThreadLocal<String> stringThreadLocal2 = new ThreadLocal<>();

    public static void main(String[] args) {
        TestMain test = new TestMain();
        test.stringThreadLocal.set("aaa");
        test.stringThreadLocal2.set("bbb");
        System.out.println(test.stringThreadLocal.get());

        /*System.out.println("proxy cat");
        StaticProxy staticProxy = new StaticProxy(new Cat());
        staticProxy.say();
        staticProxy.walk();

        System.out.println("--------------------------");
        StaticProxy staticProxyDog = new StaticProxy(new Dog());
        staticProxyDog.say();
        staticProxyDog.walk();*/
    }
}
