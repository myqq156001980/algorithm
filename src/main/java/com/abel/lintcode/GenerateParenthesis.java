package com.abel.lintcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 给定 n 对括号，请写一个函数以将其生成新的括号组合，并返回所有组合结果
 * 给定 n = 3, 可生成的组合如下:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * Created by fpschina on 16/3/2.
 */
public class GenerateParenthesis {


    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        ArrayList<String> list = generateParenthesis.generateParenthesis(3);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        String str = new String();
        findPaths(0, 0, n, str, result);
        return result;
    }

    public void findPaths(int n, int m, int sum, String str, List<String> result) {
        String str0 = new String();
        String str1 = new String();
        if (sum - n > 0) {
            str0 = str + "(";
            this.findPaths(n + 1, m + 1, sum, str0, result);
        }
        if (m > 0) {
            str1 = str + ")";
            this.findPaths(n, m - 1, sum, str1, result);
        }
        if (sum == n && m == 0) result.add(str);
    }

}
