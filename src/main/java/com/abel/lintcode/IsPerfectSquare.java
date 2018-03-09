package com.abel.lintcode;

public class IsPerfectSquare {
    /**
     * @param num: a positive integer
     * @return: if num is a perfect square else False
     * Given a positive integer num, write a function which returns True if num is a perfect square else False.
     * For example:
     * Given num = 16
     * Returns True
     */
    public boolean isPerfectSquare(int num) {
        // write yourcode here
        if (num == 0) {
            return true;
        }
        int left = 1;
        int right = num;
        while (left <= right) {
            int mid = (left + right) / 2;
            // 不能用 mid * mid == num 判断 整数越界
            int t = num / mid;
            if (t == mid && num % mid == 0) {
                return true;
            }
            if (t < mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return false;
    }
}