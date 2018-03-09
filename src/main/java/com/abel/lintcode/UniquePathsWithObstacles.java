package com.abel.lintcode;

/**
 * Created by sunzqc on 2017/8/9 16:06.
 * "不同的路径" 的跟进问题：
 * <p>
 * 现在考虑网格中有障碍物，那样将会有多少条不同的路径？
 * <p>
 * 网格中的障碍和空位置分别用 1 和 0 来表示。
 * <p>
 * 如下所示在3x3的网格中有一个障碍物：
 * <p>
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * 一共有2条不同的路径从左上角到右下角。*
 */
public class UniquePathsWithObstacles {


    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (m == 1 && n == 1) {
            return 1;
        }

        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                dp[0][i] = 0;
                break;
            } else {
                dp[0][i] = 1;
            }
        }
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
                break;
            } else {
                dp[i][0] = 1;
            }
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];

    }
}
