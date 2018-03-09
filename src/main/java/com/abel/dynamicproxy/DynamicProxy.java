package com.abel.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by sunzqc on 2017/9/5 10:52.
 */
public class DynamicProxy implements InvocationHandler {
    private Object subject;

    public DynamicProxy(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before rent house");

        System.out.println("Method " + method);


        Object o = method.invoke(subject, args);

        System.out.println("after rent house");


        return o;
    }
}
