package com.abel.lintcode;

/**
 * Created by sunzqc on 2017/8/15 17:28.
 * 有一个消息包含A-Z通过以下规则编码
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 现在给你一个加密过后的消息，问有几种解码的方式
 *
 * 您在真实的面试中是否遇到过这个题？ Yes
 * 样例
 * 给你的消息为12，有两种方式解码 AB(12) 或者 L(12). 所以返回 2
 */
public class NumDecodings {


    public static void main(String[] args) {
        NumDecodings numDecodings = new NumDecodings();

        System.out.println(numDecodings.numDecodings("0"));
    }

    /*
     * @param s: a string,  encoded message
     * @return: an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        // write your code here
        int len = s.length();

        if (len == 0) {
            return 0;
        }

        char[] chars = s.toCharArray();

        int[] nums = new int[len];
        nums[0] = 1;
        int tmpNumber1 = chars[0] - '0';
        int tmpNumber2 = chars[1] - '0';
        if (tmpNumber1 == 0 || tmpNumber2 == 0 && tmpNumber1 * 10 + tmpNumber2 > 26) {
            return 0;
        }
        if (isCombination(tmpNumber1, tmpNumber2)) {
            if(tmpNumber2 == 0){
                nums[1] = 1;
            }else {
                nums[1] = 2;
            }
        } else {
            nums[1] = 1;
        }


        for (int i = 2; i < len; i++) {
            int n1 = chars[i - 1] - '0';
            int n2 = chars[i] - '0';
            int n = n1 * 10 + n2;
            if (n1 == 0 && n2 == 0 || n2 == 0 && n > 26) {
                return 0;
            }
            if(isCombination(n1, n2)){
                if(n2 == 0){
                    nums[i] = nums[i -2];
                }else {
                    nums[i] = nums[i - 1] + nums[i - 2];
                }
            }else {
                nums[i] = nums[i - 1];
            }
        }
        return nums[len - 1];

    }

    public boolean isCombination(int n1, int n2) {
        if (n1 == 0) {
            return false;
        }
        int n = n1 * 10 + n2;
        if (n > 26) {
            return false;
        }
        return true;
    }
}
