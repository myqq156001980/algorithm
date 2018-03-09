package com.abel.design.patterns.singleton;

/**
 * Created by sunzqc on 2017/8/4 10:37.
 */
public class ThreadSafeEmperor {
    private static volatile ThreadSafeEmperor threadSafeEmperor = null;

    private ThreadSafeEmperor() {
    }

    public static ThreadSafeEmperor getInstance() {
        if (threadSafeEmperor == null) {
            synchronized (ThreadSafeEmperor.class) {
                if (threadSafeEmperor == null) {
                    threadSafeEmperor = new ThreadSafeEmperor();
                }
            }
        }
        return threadSafeEmperor;
    }
}
