package com.abel.lintcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by sunzqc on 2017/8/7 11:57.
 */
public class MedianSlidingWindow {

    /*
     * @param : A list of integers
     * @param : An integer
     * @return: The median of the element inside the window at each moving
     * 给定一个包含 n 个整数的数组，和一个大小为 k 的滑动窗口,从左到右在数组中滑动这个窗口，找到数组中每个窗口内的中位数。(如果数组个数是偶数，则在该窗口排序数字后，返回第 N/2 个数字。)
     * 对于数组 [1,2,7,8,5], 滑动大小 k = 3 的窗口时，返回 [2,7,7]

     * 最初，窗口的数组是这样的：

     * [ | 1,2,7 | ,8,5] , 返回中位数 2;

     * 接着，窗口继续向前滑动一次。

     * [1, | 2,7,8 | ,5], 返回中位数 7;

     * 接着，窗口继续向前滑动一次。

     * [1,2, | 7,8,5 | ], 返回中位数 7;
     *
     */
    public List<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        if (k == 1) {
            for (int v :
                    nums) {
                res.add(v);
            }
            return res;
        }
        if (nums.length == 0) {
            return res;
        }

        int n = nums.length;
        int m = n - k + 1; // 结果的尺寸
        //两个堆，一个最大堆，一个最小
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            // 让maxHeap始终保存小于一半的值，minHeap保存大于一半的，正好两半
            if (maxHeap.size() == 0 || maxHeap.peek() >= num)
                maxHeap.add(num);
            else minHeap.add(num);
            // 维护两个堆，保证两个堆得大小，要么保持一致（偶数时），要么maxHeap多一个（奇数时）
            if (minHeap.size() > maxHeap.size())
                maxHeap.add(minHeap.poll());
            if (maxHeap.size() > minHeap.size() + 1)
                minHeap.add(maxHeap.poll());
            // 如果需要输出
            if (i - k + 1 >= 0) {
                // 维护两个堆，保证两个堆得大小，要么保持一致（偶数时），要么maxHeap多一个（奇数时）
                if (k % 2 == 1)
                    res.add(maxHeap.peek());
                else
                    res.add(minHeap.peek() > maxHeap.peek() ? maxHeap.peek() : minHeap.peek());

                //移除并更新
                int toBeRemove = nums[i - k + 1];
                if (toBeRemove <= maxHeap.peek())
                    maxHeap.remove(toBeRemove);
                else minHeap.remove(toBeRemove);
                // 维护两个堆，保证两个堆得大小，要么保持一致（偶数时），要么maxHeap多一个（奇数时）
                if (minHeap.size() > maxHeap.size())
                    maxHeap.add(minHeap.poll());
                if (maxHeap.size() > minHeap.size() + 1)
                    minHeap.add(maxHeap.poll());

            }
        }
        return res;
    }
}
