package com.abel.lintcode;

/**
 * Created by sunzqc on 2017/8/30 10:38.
 * 找出一个序列中乘积最大的连续子序列（至少包含一个数）。
 *
 * 您在真实的面试中是否遇到过这个题？ Yes
 * 样例
 * 比如, 序列 [2,3,-2,4] 中乘积最大的子序列为 [2,3] ，其乘积为6。
 */
public class MaxProduct {

    /*
     * @param nums: An array of integers
     * @return: An integer
     */
    public int maxProduct(int[] nums) {
        // write your code here

        int posmax = nums[0], negmax = nums[0], max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int tempPosMax = posmax;
            int tempNegMax = negmax;
            posmax = Math.max(nums[i], Math.max(nums[i] * tempPosMax, nums[i] * tempNegMax));
            negmax = Math.min(nums[i], Math.min(nums[i] * tempPosMax, nums[i] * tempNegMax));
            if (Math.max(posmax, negmax) > max) {
                max = Math.max(posmax, negmax);
            }
        }

        return max;
    }
}
