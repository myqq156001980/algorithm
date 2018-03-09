package com.abel.jvmlearn;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created by sunzqc on 2017/9/7 14:57.
 * -Xmx20M -XX:MaxDirectMemorySize=10M
 */
public class DirectMemoryOOm {

    private static final int _1Mb = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);

        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1Mb);
        }
    }
}
