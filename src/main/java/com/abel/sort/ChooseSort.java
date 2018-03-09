package com.abel.sort;

/**
 * 选择排序
 * Created by fpschina on 16-1-24.
 */
public class ChooseSort extends Data {

    public static void main(String[] args) {
        ChooseSort chooseSort = new ChooseSort();
        chooseSort.init();
        chooseSort.pri();

        System.out.println();
        chooseSort.sort();
        chooseSort.pri();

    }

    private void sort() {

        for (int i = 0; i < store.length; i++) {

            int pos = i;

            int min = store[i];
            for (int j = i; j < store.length; j++) {

                if (store[j] < min) {
                    min = store[j];
                    pos = j;
                }

            }

            store[pos] = store[i];
            store[i] = min;
        }

    }

}
