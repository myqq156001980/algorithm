package com.abel.jvmlearn;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunzqc on 2017/9/6 10:37.
 */
public class HeapOOM {


    /**
     * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();

        while (true) {
            Thread.sleep(1000);
            list.add(new OOMObject());
        }
    }

    static class OOMObject {

    }
}
