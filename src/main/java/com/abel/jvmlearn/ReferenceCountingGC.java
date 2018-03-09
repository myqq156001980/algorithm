package com.abel.jvmlearn;

/**
 * Created by sunzqc on 2017/9/7 15:13.
 */
public class ReferenceCountingGC {

    private static final int _1MB = 1024 * 1024;
    public Object instance = null;

//    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();

        objA.instance = objB;
        objB.instance = objA;

        System.gc();


    }

    public static void main(String[] args) {
        testGC();
    }


}
