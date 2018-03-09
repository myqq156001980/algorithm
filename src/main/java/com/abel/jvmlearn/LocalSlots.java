package com.abel.jvmlearn;

/**
 * Created by sunzqc on 2017/9/12 14:54.
 */
public class LocalSlots {

//    public static void main(String[] args) {
//        //执行不会回收内存
//        byte[] placeholder = new byte[64 * 1024 * 1024];
//        System.gc();
//    }

//    public static void main(String[] args) {
////        离开作用域后，执行不会回收内存,因为slot槽没有被其他的复用
//        {
//            byte[] placeholder = new byte[64 * 1024 * 1024];
//        }
//        System.gc();
//    }


    public static void main(String[] args) {
//        离开作用域后，执行会回收内存，因为slots槽被复用
        {
            byte[] placeholder = new byte[64 * 1024 * 1024];
        }

        int a = 0;
        System.gc();
    }
}
