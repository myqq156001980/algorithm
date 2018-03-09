package com.abel.sort;

/**
 * Created by fpschina on 16-1-24.
 * DATA
 */
class Data {

    int[] store = new int[5];


    void init() {

//        Random r = new Random();

//        for (int i = 0; i < store.length; i++) {
//            store[i] = r.nextInt(100);
//        }
        store[0] = 9;
        store[1] = 3;
        store[2] = 2;
        store[3] = 4;
        store[4] = 8;

    }

    void pri() {

        for (int aStore : store) {
            System.out.print(" " + aStore);
        }
        System.out.println();
    }

}
