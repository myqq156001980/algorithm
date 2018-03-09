package com.abel.lintcode;

/**
 * Created by sunzqc on 2017/8/10 15:06.
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 * <p>
 * 注意事项
 * <p>
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n^2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 * 您在真实的面试中是否遇到过这个题？ Yes
 * 样例
 * Given nums = [5,5,4,3,2,1] return 5
 * Given nums = [5,4,4,3,2,1] return 4
 * <p>
 * 标签
 */
public class FindTheDuplicateNumbe {
    /**
     * @param nums an array containing n + 1 integers which is between 1 and n
     * @return the duplicate one
     */
    public int findDuplicate(int[] nums) {
        // Write your code here
        int slow = 0;
        int fast = 0;
        // 找到快慢指针相遇的地方
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        int find = 0;
        // 用一个新指针从头开始，直到和慢指针相遇, 基于第一次相遇地点和列表起始位置到循环开头的距离相同
        while (find != slow) {
            slow = nums[slow];
            find = nums[find];
        }
        return find;
    }
}
