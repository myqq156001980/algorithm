package com.abel.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by sunzqc on 2017/9/5 10:54.
 */
public class Client {

    /**
     * 动态代理需要负责代理的类实现InvocationHandler 并在其中包含需要代理的对象， 并且复写其中的invoke方法，在invoke方法中实现
     * 代理的具体逻辑。通过Proxy类的静态方法newProxyInstance 方法获取到具体的代理对象。方法需要提供三个参数1、classLoader（用于加载
     * 代理对象）2、需要代理的接口的列表（class[] 一个class的数组—）3、实现了InvocationHandler接口的类的对象。方法返回一个object
     * 需要转型为代理的接口类型。这样经过代理对象调用接口的方法会转发到代理的invoke方法处理。
     *
     * 个人理解，Proxy.newProxyInstance方法首先通过弱引用获取到实现了被代理接口的对象，对象属性中有InvocationHandler h,通过class对象
     * 获取到代理对象的构造器，传入前面实现了InvocationHandler接口的代理对象。完成动态代理对象的构建。
     *
     ** public class $Proxy0 implements Subject {
     *     private InvocationHandler h；
     *
     *     public $Proxy0(InvocationHandler h){
     *         this.h = h;
     *     }
     *
     *     @Override
     *     public void rent() {
     *         h.invoke(this, rent, null);
     *     }
     *
     *     @Override
     *     public void hello(String str) {
     *         h.invoke(this, hello, new Object[]{str});
     *     }
     *
     *     @Override
     *     public int add(int a, int b) {
     *         return h.invoke(this, add, new Object[]{a, b});
     *     }
     *
     * }
     *
     *
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        Subject realSubject = new RealSubject();

        InvocationHandler handler = new DynamicProxy(realSubject);

        Subject subject = (Subject) Proxy.newProxyInstance(realSubject.getClass().getClassLoader(), new Class[]{Subject.class}, handler);
        System.out.println(subject.getClass().getName());

        subject.rent();

        subject.hello("world");

        int r = subject.add(2, 3);
        System.out.println(r);
    }
}
