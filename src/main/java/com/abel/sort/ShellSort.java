package com.abel.sort;

/** shell 排序
 * Created by fpschina on 16-1-24.
 */
public class ShellSort extends Data{

    private void shellSortInsert(int dk){
        for (int i = dk; i < store.length; i++) {
            if(store[i] < store[i - dk]){

                int j = i - dk;
                int x = store[i];

                store[i] = store[i- dk];

                while (j >= 0 && x < store[j]){
                    store[j + dk] = store[j];
                    j -= dk;
                }


                store[j + dk] = x;

            }
        }
    }

    private void shellSort(){
        int dk = store.length/2;
        while (dk >= 1){
            shellSortInsert(dk);
            dk /=2;
        }
    }


    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();

        shellSort.init();
        shellSort.pri();

        System.out.println();
        shellSort.shellSort();
        shellSort.pri();
    }

}
