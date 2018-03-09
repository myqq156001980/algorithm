package com.abel.lintcode;

/**
 * Created by sunzqc on 2017/8/7 16:45.
 * We are playing the Guess Game. The game is as follows:
 * I pick a number from 1 to n. You have to guess which number I picked.
 * Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.
 * However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.
 *
 *
 * Given n = 10, I pick 8.
 * First round: You guess 5, I tell you that it's higher. You pay $5.
 * Second round: You guess 7, I tell you that it's higher. You pay $7.
 * Third round: You guess 9, I tell you that it's lower. You pay $9.
 *
 * Game over. 8 is the number I picked.
 * You end up paying $5 + $7 + $9 = $21.
 *
 * Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
 * So when n = ｀10, return16`
 */
public class GetMoneyAmount {


    /**
     * @param n an integer
     * @return how much money you need to have to guarantee a win
     */
    public int getMoneyAmount(int n) {
        // Write your code here
        int[][] dp = new int[n + 2][n + 2];
        for (int width = 1; width < n; width++) {
            for (int start = 1, end = start + width; end <= n; start++, end++) {
                dp[start][end] = Integer.MAX_VALUE;
                for (int k = start; k <= end; k++) {
                    // 在1-n个数里面，我们任意猜一个数(设为i)，保证获胜所花的钱应该为 i + max(w(1 ,i-1), w(i+1 ,n))，
                    // 这里w(x,y))表示猜范围在(x,y)的数保证能赢应花的钱，则我们依次遍历 1-n作为猜的数，
                    // 求出其中的最小值即为答案，即最小的最大值问题
                    dp[start][end] = Math.min(dp[start][end], k + Math.max(dp[start][k - 1], dp[k + 1][end]));
                }
            }
        }
        return dp[1][n];
    }
}
