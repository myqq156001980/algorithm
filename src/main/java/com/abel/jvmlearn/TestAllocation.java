package com.abel.jvmlearn;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunzqc on 2017/9/7 16:48.
 */
public class TestAllocation {

    private static final int _1MB = 1024 * 1024;


    /**
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:+PrintGCDetails
     */
    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB]; // 出现一次minor GC

    }


    /**
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:+PrintGCDetails
     * -XX:+PretenuredSizeThreshold=3145728
     * -XX:PretenureSizeThreshold=3145728
     */
    public static void testPreTenureSizeThreshold() {
        byte[] allocation;

        allocation = new byte[4 * _1MB];
    }


    /**
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:+PrintGCDetails
     * -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
     */
    public static void testTenuringThreshold() {
        byte[] allocation1, allocation2, allocation3;

        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[_1MB * 4];
        allocation3 = new byte[_1MB * 4];
        allocation3 = null;
        allocation3 = new byte[_1MB * 4];

    }


    public static void main(String[] args) throws InterruptedException {
//        testAllocation();
//        testPreTenureSizeThreshold();

//        testTenuringThreshold();

        fillHeap(1000);
    }




    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(50);
            list.add(new OOMObject());

        }

        System.gc();

    }


    static class OOMObject {
        public byte[] placeHolder = new byte[64 * 1024];
    }

}
