package com.abel.lintcode;

/**
 * Created by sunzqc on 2017/8/9 16:26.
 * 给定一个只含非负整数的m*n网格，找到一条从左上角到右下角的可以使数字和最小的路径。
 */
public class MinPathSum {

    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        // write your code here
        int m = grid.length;
        int n = grid[0].length;
        if (m == 0) {
            return 0;
        }
        if (n == 1) {
            int sum = 0;
            for (int v : grid[0]) {
                sum += v;
            }
            return sum;
        }
        // 建立动态数组
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        // 初始化数组
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 抵达dp[i][j] 所经过的最小路径为grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[m - 1][n - 1];

    }
}
