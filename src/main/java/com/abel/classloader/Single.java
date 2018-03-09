package com.abel.classloader;

/**
 * Created by sunzqc on 2017/9/4 09:53.
 */
public class Single {
    private static Single single = null;

    private Single() {
    }

    public static Single getInstance() {
        if (single == null) {
            synchronized (Single.class) {
                if (single == null) {
                    single = new Single();
                }
            }
        }
        return single;
    }

}
