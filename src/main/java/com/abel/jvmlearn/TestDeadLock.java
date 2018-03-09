package com.abel.jvmlearn;

/**
 * Created by sunzqc on 2017/9/8 14:50.
 */
public class TestDeadLock implements Runnable{
    int a, b;

    public TestDeadLock(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        synchronized (Integer.valueOf(a)){
            synchronized (Integer.valueOf(b)){
                System.out.println(a + b);
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new TestDeadLock(1, 2)).start();
            new Thread(new TestDeadLock(2, 1)).start();
        }
    }
}
