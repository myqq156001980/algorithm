package com.abel.sort;

/**
 * 快速排序
 * Created by fpschina on 16-1-24.
 */
public class QuickSort extends Data {

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        quickSort.init();
        quickSort.pri();
        System.out.println();
        quickSort.sort(0, 4);
        quickSort.pri();
    }

    /**
     * 交换位置
     */
    private void swap(int p1, int p2) {
        int tmp = store[p2];
        store[p2] = store[p1];
        store[p1] = tmp;
    }

    /**
     * 注意开始的位置先,因为选择 low 为起点,while 中要从 high 开始寻找，如果要降序排列颠倒>=符号的方向
     */
    private int patition(int low, int high) {
        int pivotkey = store[low];

        while (low < high) {
            while (low < high && store[high] >= pivotkey) {
                high--;
            }
            swap(low, high);
            pri();

            while (low < high && store[low] <= pivotkey) {
                low++;
            }
            swap(low, high);
            pri();

        }
        return low;
    }

    private void sort(int low, int high) {
        if (low < high) {
            int privotloc = patition(low, high);
            sort(low, privotloc - 1);
            sort(privotloc + 1, high);
        }

    }
}
