package com.abel.lintcode;

/**
 * Created by sunzqc on 2017/8/9 16:07.
 * 有一个机器人的位于一个 m × n 个网格左上角。
 * <p>
 * 机器人每一时刻只能向下或者向右移动一步。机器人试图达到网格的右下角。
 * <p>
 * 问有多少条不同的路径？
 * <p>
 * 注意事项
 * <p>
 * n和m均不超过100
 * <p>
 * 您在真实的面试中是否遇到过这个题？ Yes
 * 样例
 * 给出 m = 3 和 n = 3, 返回 6.
 * 给出 m = 4 和 n = 5, 返回 35.
 */
public class UniquePaths {

    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
        // write your code here
        int dp[] = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}
