package com.abel.synchronize;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by sunzqc on 2017/12/5 13:25.
 */

class Node {
    public int i = 0;
}

/***
 * LockSupport 使用UnSafe 类中的park 和unPark 同步原语进行同步
 * park时可以传入需要同步的对象，后续使用LockSupport.getBlocker(t1);获取传入的同步对象
 * t1为阻塞的线程
 */
public class LockSupportTest {


    public static void main(String[] args) throws InterruptedException {
        Node node1 = new Node();
        Node node2 = new Node();
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {

                    System.out.println(Thread.currentThread().getName() + "=====" + node1.i++);


                    if (node1.i == 5) {
                        System.out.println("======");
                        LockSupport.park(node1);
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    Node n1 = (Node) LockSupport.getBlocker(t1);
                    if (n1 != null && n1.i == 10) {
                        LockSupport.unpark(t1);
                    }

                    if (n1 != null && node2.i == 10) {
                        n1.i = 10;
                    }
                    System.out.println(Thread.currentThread().getName() + "=====" + node2.i++);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }, "t2");

        t2.start();
        t1.start();


    }
}
