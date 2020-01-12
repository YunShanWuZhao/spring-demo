package com.example.spring.design.proxy;

public class StaticProxy implements Target {

    Target target;

    public StaticProxy (Target target){
        this.target = target;
    }

    @Override
    public void say() {
        System.out.println("using static proxy ;before say,do something");
        target.say();
        System.out.println("using static proxy; end say, do something");
    }

    @Override
    public void walk() {
        System.out.println("using static proxy;before walk, do something");
        target.walk();
        System.out.println("using staic proxy; end walk, do something");
    }
}
