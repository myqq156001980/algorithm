package com.abel.lintcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by sunzqc on 2017/8/7 14:11.
 * 给定一个二叉树，找出所有路径中各节点相加总和等于给定 目标值 的路径。一个有效的路径，指的是从根节点到叶节点的路径。
 * * 样例
 * 给定一个二叉树，和 目标值 = 5:
 *
 *      1
 *     / \
 *    2   4
 *   / \
 *  2   3
 * 返回：
 *
 * [
 *   [1, 2, 2],
 *   [1, 4]
 * ]
 *
 */
public class BinaryTreePathSum {

    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<>();
        if(null == root) return result;
        Stack<Integer> stack = new Stack<>();
        binaryTreePathSum(result, stack, root, 0, target);
        return result;
    }


    public void binaryTreePathSum(List<List<Integer>> result, Stack<Integer> stack, TreeNode root, int sum, int target) {
        sum += root.val;
        stack.push(root.val);
        if(sum == target && root.left == null && root.right == null) {
            List<Integer> list = new ArrayList<>(stack);
            result.add(list);
            stack.pop();
            return;
        }else {
            if(root.left != null)
                binaryTreePathSum(result, stack, root.left, sum, target);
            if(root.right != null)
                binaryTreePathSum(result, stack, root.right, sum, target);
            stack.pop();
        }
    }
}
