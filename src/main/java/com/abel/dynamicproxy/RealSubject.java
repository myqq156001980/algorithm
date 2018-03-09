package com.abel.dynamicproxy;

/**
 * Created by sunzqc on 2017/9/5 10:52.
 */
public class RealSubject implements Subject {
    @Override
    public void rent() {
        System.out.println("I want to rent house");
    }

    @Override
    public void hello(String str) {
        System.out.println("hello " + str);
    }

    @Override
    public int add(int a, int b) {
        return a + b;
    }
}
