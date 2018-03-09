package com.abel.jvmlearn;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunzqc on 2017/9/6 11:26.
 */
public class RuntimeConstantPoolOOM {


    /**
     * -XX:PermSize=10M -XX: MaxPermSize=10M
     * @param args
     */
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
//        List<HeapOOM> list = new ArrayList<>();
        int i = 0;
        while (true) {
//            list.add(new HeapOOM());
            list.add(String.valueOf(i).intern());
        }

    }
}
