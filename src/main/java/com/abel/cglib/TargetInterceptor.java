package com.abel.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by sunzqc on 2017/9/7 14:45.
 */
public class TargetInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("调用前");

        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("调用后 :" + result);
        return result;
    }
}
