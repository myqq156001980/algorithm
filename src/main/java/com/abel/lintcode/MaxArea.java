package com.abel.lintcode;

/**
 * Created by sunzqc on 2017/8/16 11:33.
 * 给定 n 个非负整数 a1, a2, ..., an, 每个数代表了坐标中的一个点 (i, ai)。画 n 条垂直线，使得 i 垂直线的两个端点分别为(i, ai)和(i, 0)。找到两条线，使得其与 x 轴共同构成一个容器，以容纳最多水。
 * <p>
 * 注意事项
 * <p>
 * 容器不可倾斜。
 * <p>
 * 您在真实的面试中是否遇到过这个题？ Yes
 * 样例
 * 给出[1,3,2], 最大的储水面积是2.
 */
public class MaxArea {
    /*
     * @param : a vector of integers
     * @return: an integer
     */
    public int maxArea(int[] heights) {
        // write your code here
        int len = heights.length;
        if (len < 2) {
            return 0;
        }

        int max = 0;
        int l = 0, r = len - 1;
        while (l < r){
            max = Math.max(max, Math.min(heights[r], heights[l]) * (r - l));
            if(heights[l] < heights[r]){
                l++;
            }else {
                r--;
            }
        }
        return max;

    }
}
