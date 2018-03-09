package com.abel.lintcode;

/**
 * Created by sunzqc on 2017/8/31 10:45.
 * <p>
 * 给出两个字符串，找到最长公共子串，并返回其长度。
 * <p>
 * 注意事项
 * 子串的字符应该连续的出现在原字符串中，这与子序列有所不同。
 * <p>
 * 您在真实的面试中是否遇到过这个题？ Yes
 * 样例
 * 给出A=“ABCD”，B=“CBCE”，返回 2
 */
public class LongestCommonSubstring {


    public int longestCommonSubstring(String A, String B) {
        // write your code here
        if (A.length() == 0 || B.length() == 0) {
            return 0;
        }

        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        int[][] table = new int[a.length][b.length];
        int start1 = -1;
        int start2 = -1;

        int longest = 0;

        for (int i = 0; i < b.length; i++) {
            table[0][i] = (a[0] == b[i] ? 1 : 0);
        }

        for (int i = 1; i < a.length; i++) {
            table[i][0] = (a[i] == b[0] ? 1 : 0);
            for (int j = 1; j < b.length; j++) {
                if (a[i] == b[j]) {
                    table[i][j] = table[i - 1][j - 1] + 1;
                }
            }
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (longest < table[i][j]) {
                    longest = table[i][j];
                    start1 = i - longest + 1;
                    start2 = j - longest + 1;
                }

            }
        }

        return longest;

    }
}
