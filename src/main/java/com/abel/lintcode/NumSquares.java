package com.abel.lintcode;

import java.util.Arrays;

/**
 * Created by sunzqc on 2017/8/16 15:39.
 * 给一个正整数 n, 找到若干个完全平方数(比如1, 4, 9, ... )使得他们的和等于 n。你需要让平方数的个数最少。
 * <p>
 * 您在真实的面试中是否遇到过这个题？ Yes
 * 样例
 * 给出 n = 12, 返回 3 因为 12 = 4 + 4 + 4。
 * 给出 n = 13, 返回 2 因为 13 = 4 + 9。
 */
public class NumSquares {
    /*
    * @param n: a positive integer
    * @return: An integer
    */
    public int numSquares(int n) {
        // write your code here
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i * i <= n; i++)
            dp[i * i] = 1;
        for (int i = 1; i <= n; i++) {  //选定第一个数为 i
            for (int j = 1; i + j * j <= n; j++) {  //选定另一个数为 j*j
                dp[i + j * j] = Math.min(dp[i] + 1, dp[i + j * j]);  //从小到大查找
            }
        }
        return dp[n];
    }

}
