package com.abel.lintcode;

/**
 * Created by sunzqc on 2017/8/7 14:01.
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining. Trapping Rain Water
 * 如上图所示，海拔分别为 [0,1,0,2,1,0,1,3,2,1,2,1], 返回 6.
 */
public class TrapRainWater {
    /**
     * @param heights: an array of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        // write your code here

        int res = 0;
        if(heights==null||0==heights.length) return res;
        int len = heights.length;
        int l = 0 ; int r = len-1;
        int lmax = 0; int rmax = 0;
        while(l<r){
            lmax = Math.max(lmax, heights[l]);
            rmax = Math.max(rmax, heights[r]);
            if(lmax>rmax){
                res += rmax-heights[r];
                r--;
            }else{
                res += lmax-heights[l];
                l++;
            }
        }
        return res;
    }
}
