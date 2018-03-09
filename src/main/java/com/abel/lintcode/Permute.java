package com.abel.lintcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author sunzequn
 * @create 2018-02-07 下午1:46
 * @desc 全排列
 **/
public class Permute {


    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     ** 样例
     * 给出一个列表[1,2,3]，其全排列为：
     *
     * [
     *   [1,2,3],
     *   [1,3,2],
     *   [2,1,3],
     *   [2,3,1],
     *   [3,1,2],
     *   [3,2,1]
     * ]
     *
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        Queue<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            List<Integer> tmp = new ArrayList<>();
            res.offer(tmp);
            return new ArrayList<>(res);
        }
        for (int i = 0; i < nums.length; i++) {
            if (res.isEmpty()) {
                List<Integer> t = new ArrayList<>();
                t.add(nums[i]);
                res.add(t);
            } else {
                int index = res.size();
                int k = 0;
                while (k < index) {
                    List<Integer> tmp = res.poll();
                    int l = tmp.size();
                    for (int j = 0; j <= l; j++) {
                        List<Integer> s = new ArrayList<>(tmp);
                        s.add(j, nums[i]);
                        res.offer(s);
                    }
                    k++;
                }
            }
        }

        return new ArrayList<>(res);

    }

    public List<List<Integer>> recursionermute(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        if (nums.length == 1) {
            List<Integer> t = new ArrayList<>();
            t.add(nums[0]);
            res.add(t);
            return res;
        }
        if (nums.length == 0) {
            List<Integer> t = new ArrayList<>();
            res.add(t);
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            int index = 0;
            int mark = i;
            int[] t = new int[nums.length - 1];
            for (int j = 0; j < nums.length - 1; ) {
                if (index != mark) {
                    t[j++] = nums[index++];
                } else {
                    index++;
                }
            }
            List<List<Integer>> tmp = recursionermute(t);
            for (List<Integer> v :
                    tmp) {
                v.add(nums[i]);
            }
            res.addAll(tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 2};
        Permute permute = new Permute();
        System.out.println(permute.permute(a));
        List<List<Integer>> l = new ArrayList<>();
        List<Integer> t = new ArrayList<>();
        l.add(t);
        System.out.println(l);

    }
}
