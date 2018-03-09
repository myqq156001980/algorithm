package com.abel.javassist.demo1;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtMethod;

public class TestByteCode {
    public static void main(String[] args) throws Exception {

        ClassPool pool = ClassPool.getDefault();
        CtClass pt = pool.makeClass("asdf", pool.get("com.abel.javassist.demo1.TestBean"));
        CtMethod method1 = new CtMethod(pool.get("java.lang.String"), "getM", null, pt);
        method1.setBody("{return \"你好\";}");
        pt.addMethod(method1);
        CtConstructor cc = new CtConstructor(null, pt);
        cc.setBody("this.field=\"why?\";");
        pt.addConstructor(cc);
        CtMethod method2 = new CtMethod(CtClass.voidType, "setF",
                new CtClass[]{pool.get("java.lang.String")}, pt);
        method2.setBody("{this.field=$1;}");
        pt.addMethod(method2);
        Class<?> c = pt.toClass();
        TestBean bean = (TestBean) c.newInstance();
        System.out.println(bean.getM());
        System.out.println(bean.getF());
        bean.setF("setf");
        System.out.println(bean.getF());
    }
}