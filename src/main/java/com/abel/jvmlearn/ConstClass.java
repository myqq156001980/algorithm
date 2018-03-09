package com.abel.jvmlearn;

/**
 * Created by sunzqc on 2017/9/11 16:01.
 */
public class ConstClass {

    static {
        System.out.println("ConstClass init!");
    }

    public static final String HELLOWORLD = "hello world!";


    public static void main(String[] args) {
        System.out.println(ConstClass.HELLOWORLD);
    }


}
