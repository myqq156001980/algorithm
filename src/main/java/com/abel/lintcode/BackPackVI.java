package com.abel.lintcode;

/**
 * Created by sunzqc on 2017/8/11 11:16.
 * 给出一个都是正整数的数组 nums，其中没有重复的数。从中找出所有的和为 target 的组合个数。
 * 注意事项
 *
 * 一个数可以在组合中出现多次。
 * 数的顺序不同则会被认为是不同的组合。
 *
 * 您在真实的面试中是否遇到过这个题？ Yes
 * 样例
 * 给出 nums = [1, 2, 4], target = 4
 * 可能的所有组合有：
 *
 * [1, 1, 1, 1]
 * [1, 1, 2]
 * [1, 2, 1]
 * [2, 1, 1]
 * [2, 2]
 * [4]*
 */
public class BackPackVI {

    /**
     * @param nums an integer array and all positive numbers, no duplicates
     * @param target an integer
     * @return an integer
     */
    public int backPackVI(int[] nums, int target) {
        // Write your code here
        int[] dp=new int[target+1];
        dp[0]=1;
        for(int i=1;i<=target;i++){
            for(int j=0;j<nums.length;j++){
                if(nums[j]<=i){
                    dp[i]+=dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }
}
