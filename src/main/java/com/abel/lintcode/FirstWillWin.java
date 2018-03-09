package com.abel.lintcode;

/**
 * Created by sunzqc on 2017/8/31 11:05.
 * 硬币排成线
 * <p>
 * 有 n 个硬币排成一条线。两个参赛者轮流从右边依次拿走 1 或 2 个硬币，直到没有硬币为止。拿到最后一枚硬币的人获胜。
 * <p>
 * 请判定 第一个玩家 是输还是赢？
 * <p>
 * 您在真实的面试中是否遇到过这个题？ Yes
 * 样例
 * n = 1, 返回 true.
 * <p>
 * n = 2, 返回 true.
 * <p>
 * n = 3, 返回 false.
 * <p>
 * n = 4, 返回 true.
 * <p>
 * n = 5, 返回 true.
 * <p>
 * 挑战
 * O(1) 时间复杂度且O(1) 存储。*
 */
public class FirstWillWin {
    /**
     * @param n: an integer
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        // write your code here
        return n % 3 != 0;
    }
}
