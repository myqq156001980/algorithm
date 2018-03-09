package com.abel.sort;

import java.util.Random;

/**插入排序
 * Created by fpschina on 16-1-24.
 */
public class DirectInsert {

    private int[] store;

    private DirectInsert(){
        store = new int[10];
    }

    private void init(){

        Random r = new Random();

        for (int i = 0; i < store.length; i++) {
            store[i] = r.nextInt(100);
        }
    }


    private void sort(){

        for (int i = 1; i < store.length; i++) {

            if(store[i] < store[i - 1]){

                int j = i - 1;
                int x = store[i];

//                store[i] = store[i - 1];
                while (j >= 0 && x < store[j]){
                    store[j + 1] = store[j];
                    j--;
                }
                store[j + 1] = x;
            }
        }


    }

    private void pri(){

        for (int aStore : store) {
            System.out.print(" " + aStore);
        }
    }

    public static void main(String[] args) {
        DirectInsert directInsert = new DirectInsert();

        directInsert.init();
        directInsert.pri();
        System.out.println();
        directInsert.sort();
        directInsert.pri();
    }


}
