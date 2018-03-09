package com.abel.lintcode;

/**
 * Created by sunzqc on 2017/8/29 16:11.
 * 在不排序的情况下查找无序数组中第k大的数
 * <p>
 * 思路：寻找第K个大元素。
 * 具体方法：使用类似快速排序，执行一次快速排序后，每次只选择一部分继续执行快速排序，直到找到第K个大元素为止，此时这个元素在数组位置后面的元素即所求
 * 时间复杂度：
 * 若随机选取枢纽，线性期望时间O(N)
 * 若选取数组的“中位数的中位数”作为枢纽，最坏情况下的时间复杂度O（N）
 * 利用快速排序的思想，从数组S中随机找出一个元素X，把数组分为两部分Sa和Sb。Sa中的元素大于等于X，Sb中元素小于X。这时有两种情况：
 * 1. Sa中元素的个数小于k，则Sb中的第k-|Sa|个元素即为第k大数；
 * 2. Sa中元素的个数大于等于k，则返回Sa中的第k大数。
 * 利用快排的partion思想 T(n) = 2T(n/2) + O(1)   时间复杂度为O(n)
 * 该方法只有当我们可以修改输入的数组时可用，位于数组左边的k个数字就是最小的k个数字（但这k个数字不一定是排序的），位于第k个数右边的数字都比第k个数字大*
 */
public class FindKthNumber {

    public static void main(String[] args) {
        int[] a = {15, 25, 9, 48, 36, 100, 58, 99, 126, 5};
        System.out.println("排序前：");
        for (int v :
                a) {
            System.out.print(v + " ");
        }

        System.out.println();

        FindKthNumber findKthNumber = new FindKthNumber();
        findKthNumber.findKthNumber(4, a, 0, a.length - 1);

        findKthNumber.quickSort(a, 0, a.length - 1);
        System.out.println("排序后：");
        for (int v :
                a) {
            System.out.print(v + " ");
        }

    }


    public int partition(int[] l, int low, int high) {

        int pt = l[low];
        while (low < high) {
            while (low < high && l[high] >= pt) {
                high--;
            }

            l[low] = l[high];

            while (low < high && l[low] <= pt) {
                low++;
            }
            l[high] = l[low];
        }
        l[low] = pt;
        return low;
    }

    public void quickSort(int[] l, int low, int high) {
        int pl;
        if (low < high) {
            pl = partition(l, low, high);
            quickSort(l, low, pl - 1);
            quickSort(l, pl + 1, high);
        }
    }

    public void findKthNumber(int k, int[] l, int low, int high) {
        int tmp;
        tmp = partition(l, low, high);

        if (tmp == k - 1) {
            System.out.println("第 " + k + "大的数字是: " + l[tmp]);
        } else if (tmp > k - 1) {
            findKthNumber(k, l, low, tmp - 1);
        } else {
            findKthNumber(k, l, tmp + 1, high);
        }

    }


}
