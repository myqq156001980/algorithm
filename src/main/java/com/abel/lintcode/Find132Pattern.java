package com.abel.lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunzqc on 2017/8/10 15:27.
 * Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj. Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern in the list.
 * <p>
 * n will be less than 20,000.
 * <p>
 * 您在真实的面试中是否遇到过这个题？ Yes
 * 样例
 * Given nums = [1, 2, 3, 4]
 * return False // There is no 132 pattern in the sequence.
 * <p>
 * Given nums = [3, 1, 4, 2]
 * return True // There is a 132 pattern in the sequence: [1, 4, 2].
 */
public class Find132Pattern {


    /**
     * @param nums a list of n integers
     * @return true if there is a 132 pattern or false
     */
    public boolean find132pattern(int[] nums) {
        // Write your code here
        List<Integer> start = new ArrayList<>();
        List<Integer> end = new ArrayList<>();

        int small = Integer.MAX_VALUE;
        int big = Integer.MIN_VALUE;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > nums[i - 1]) {
                if (nums[i] > big) {
                    big = nums[i];
                }
                if (nums[i - 1] < small) {
                    small = nums[i - 1];
                }
                for (int k = 0; k < start.size(); k++) {
                    if (nums[i] > start.get(k) && nums[i] < end.get(k)) {
                        return true;
                    }
                }
            } else {
                if (nums[i] > small) {
                    return true;
                }
                for (int k = 0; k < start.size(); k++) {
                    if (nums[i] > start.get(k) && nums[i] < end.get(k)) {
                        return true;
                    }
                }
                if (big > Integer.MIN_VALUE) {
                    start.add(small);
                    end.add(big);
                    //System.out.printf("start: %d, end: %d\n", small, big);
                    small = Integer.MAX_VALUE;
                    big = Integer.MIN_VALUE;
                }

            }
        }
        return false;

    }


}
