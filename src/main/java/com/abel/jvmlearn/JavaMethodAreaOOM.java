package com.abel.jvmlearn;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;


/**
 * Created by sunzqc on 2017/9/7 14:20.
 */
public class JavaMethodAreaOOM {


    /**
     * -verbose:gc -XX:MaxMetaspaceSize=10M
     * <p>
     * jdk1.8 移除了 permanent Generation ，变成了Metadata space
     *
     * @param args
     */
    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o, objects);
                }
            });

            enhancer.create();
        }
    }

    static class OOMObject {
    }
}
