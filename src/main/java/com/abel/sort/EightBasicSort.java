package com.abel.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by sunzqc on 2017/7/18 17:32.
 */
public class EightBasicSort {

    public static void main(String[] args) {
//        int[] a = {62, 9, 3, 35, 25, 65, 77, 0, 17, 25, 68, 59, 45, 96, 88, 70, 84, 96, 52, 79, 56, 10, 6, 60, 56, 71, 51, 89, 70, 38};
        int[] a = getRandomArray(31);
//        quick(a, 0, a.length - 1);

//        insertSort(a);
//        shellSort(a);

//        selectSort(a);
//        bubbleSort(a);

        mergingSort(a, 0, a.length - 1);
//        radixSort(a);
//        heapSort(a);
        for (int v : a) {
            System.out.print(v + " ");
        }


    }

    /**
     * 获取随机数组，并打印数组初始化结果
     *
     * @param size 数组大小
     * @return 初始化的随机数组
     */
    public static int[] getRandomArray(int size) {
        int[] a = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            a[i] = random.nextInt(300);
        }

        for (int i = 0; i < a.length; i++) {
            if (i != a.length - 1) {
                System.out.print(a[i] + ",");
            } else {
                System.out.print(a[i] + "\n");
            }
        }

        return a;


    }

    /**
     * 快速排序
     *
     * @param a    待排序数组
     * @param left  低位
     * @param right 高位
     * @return 分割位置
     */
    public static int partition(int[] a, int left, int right) {
        int pivot = a[left];   // 数组的第一个作为中轴
        while (left < right) {
            while (left < right && a[right] >= pivot) {
                right--;
            }
            a[left] = a[right];   // 比中轴小的记录移到低端
            while (left < right && a[left] <= pivot) {
                left++;
            }
            a[right] = a[left]; // 比中轴大的记录移到高端
        }
        a[left] = pivot;   // 中轴记录到尾
        return left; // 返回中轴位置

    }

    /**
     * 快速排序
     *
     * @param a    待排序数组
     * @param left  低位(0)
     * @param right 高位(a.length - 1)
     */
    public static void quick(int[] a, int left, int right) {
        if (a == null || a.length < 2) {
            return;
        }

        if (left < right) {
            int middle = partition(a, left, right); //将数组一分为二
            quick(a, left, middle - 1);  //对低字表进行递归排序
            quick(a, middle + 1, right); //对高字表进行地柜排序
        }
    }


    /**
     * 直接插入排序
     *
     * @param a 等待排序数组
     */
    public static void insertSort(int[] a) {
        if (a == null || a.length < 2) {
            return;
        }

        for (int i = 1; i < a.length; i++) {
            int j = i - 1;
            int findPos = a[i];
            for (; j >= 0 && findPos < a[j]; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = findPos;

        }

    }

    /**
     * 希尔排序
     *
     * @param a 待排序数组
     */
    public static void shellSort(int[] a) {
        if (a == null || a.length < 2) {
            return;
        }
        int l = a.length;
        while (true) {
            l = l / 2;
            for (int i = 0; i < l; i++) {
                for (int j = i + l; j < a.length; j += l) {
                    int x = j - l;
                    int findPos = a[j];
                    for (; x >= 0 && findPos < a[x]; x -= l) {
                        a[x + l] = a[x];
                    }
                    a[x + l] = findPos;
                }
            }
            if (l == 1) {
                break;
            }
        }
    }


    /**
     * 冒泡排序
     *
     * @param a 待排序数组
     */
    public static void bubbleSort(int[] a) {
        if (a == null || a.length < 2) {
            return;
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }

            }

        }
    }

    /**
     * 选择排序
     *
     * @param a 待排序数组
     */
    public static void selectSort(int[] a) {
        if (a == null || a.length < 2) {
            return;
        }
        for (int i = 0; i < a.length; i++) {
            int j = i + 1;
            int position = i;
            int min = a[i];
            for (; j < a.length; j++) {
                if (min > a[j]) {
                    min = a[j];
                    position = j;
                }
            }
            a[position] = a[i];
            a[i] = min;

        }
    }

    /**
     * 归并排序
     *
     * @param a     待排序数组
     * @param left  0
     * @param right a.length - 1
     */
    public static void mergingSort(int[] a, int left, int right) {
        if (a == null || a.length < 2) {
            return;
        }
        if (left < right) {
            //找出中间索引
            int center = (left + right) / 2;
            //对左边数组进行递归
            mergingSort(a, left, center);
            //对右边数组进行递归
            mergingSort(a, center + 1, right);
            //合并
            merge(a, left, center, right);

        }

    }

    /**
     * 归并排序，合并数组
     *
     * @param a      待排序数组
     * @param left   待合并数组起始位置
     * @param center 待合并数组中间位置
     * @param right  待合并数组结束位置
     */
    public static void merge(int[] a, int left, int center, int right) {
        //初始化储存数组
        int[] tmpArr = new int[right - left + 1];
        int mid = center + 1;
        int third = 0;
        //记录起始位置
        int mark = left;
        while (left <= center && mid <= right) {
            tmpArr[third++] = a[left] <= a[mid] ? a[left++] : a[mid++];
        }

        // 复制剩余数据
        while (mid <= right) {
            tmpArr[third++] = a[mid++];
        }
        // 复制剩余数组
        while (left <= center) {
            tmpArr[third++] = a[left++];
        }

        // 将数组复制回对应位置
        for (int i = 0; i < tmpArr.length; i++) {
            a[i + mark] = tmpArr[i];
        }

    }

    /**
     * 基数排序
     *
     * @param a 待排序数组
     */
    public static void radixSort(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }

        int time = 0;
        // 判断位数
        while (max > 0) {
            max /= 10;
            time++;
        }
        // 建立10个队列
        List<ArrayList> queue = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> queue1 = new ArrayList<>();
            queue.add(queue1);
        }

        for (int i = 0; i < time; i++) {
            for (int j = 0; j < a.length; j++) {
                // 得到数字第  time + 1 位数
                int x = a[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
                ArrayList<Integer> queue2 = queue.get(x);
                queue2.add(a[j]);
            }

            int count = 0;
            for (int k = 0; k < 10; k++) {
                while (queue.get(k).size() > 0) {
                    ArrayList<Integer> queue3 = queue.get(k);
                    a[count] = queue3.get(0);
                    queue3.remove(0);
                    count++;
                }
            }

        }

    }

    /**
     * 堆排序
     *
     * @param a 待排序数组
     */
    public static void heapSort(int[] a) {
        if (a == null || a.length < 2) {
            return;
        }
        int arrayLength = a.length;
        //  循环建立堆
        for (int i = 0; i < arrayLength - 1; i++) {
            //  建立堆
            buildMaxHeap(a, arrayLength - 1 - i);
            //  交换堆顶和最后一个元素
            swap(a, 0, arrayLength - 1 - i);
            System.out.println(Arrays.toString(a));

        }

    }

    /**
     * 交换元素
     *
     * @param a 待交换数组
     * @param i position i
     * @param j position j
     */
    public static void swap(int[] a, int i, int j) {
        a[i] = a[i] ^ a[j];
        a[j] = a[i] ^ a[j];
        a[i] = a[i] ^ a[j];
    }

    /**
     * 对待排序数组从0 到 lastIndex建立大顶堆
     *
     * @param a         待排序数组
     * @param lastIndex lastIndex
     */
    private static void buildMaxHeap(int[] a, int lastIndex) {
        // 从lastIndex处节点(最后一个节点) 的父节点开始
        for (int i = lastIndex / 2; i >= 0; i--) {
            //  k保存正在判断的节点
            int k = i, biggerIndex;
            //  如果当前k节点的子节点存在
            while ((biggerIndex = k * 2 + 1) <= lastIndex) {

                //  如果biggerIndex小于lastIndex. 即biggerIndex+1代表的k节点的右子节点存在
                if (biggerIndex < lastIndex && a[biggerIndex] < a[biggerIndex + 1]) {
                    //  如果右子节点的值较大
                    //  biggerIndex总是记录较大子节点索引
                    biggerIndex++;

                }
                //  如果k节点的值小于其较大的子节点的值
                if (a[k] < a[biggerIndex]) {
                    //  交换它们
                    swap(a, k, biggerIndex);
                    //  将biggerIndex赋予k,开始while循环的下一次循环,由于交换了K，和biggerIndex节点，重新保证k节点的值大于其左右子节点的值
                    k = biggerIndex;
                } else {
                    break;
                }
            }

        }

    }

}
