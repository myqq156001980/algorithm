package com.abel.lintcode;

/**
 * Created by sunzqc on 2017/10/13 14:08.
 * <p>
 * 给定一个整数数组，其实只有一个数字出现了一次，其余的数字出现了三次，用线性的时间复杂度
 * 找出出现一次的数字。不使用额外的储存空间。
 */
public class FindOneInThree {


    public static int findAlone(int[] a) {
        int ones = 0, twos = 0;
        for (int i = 0; i < a.length; i++) {
            ones = (ones ^ a[i]) & (~twos);
            twos = (twos ^ a[i]) & (~ones);
        }
        return ones;

    }
}
