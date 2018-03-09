package com.abel.lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给一棵二叉树，找出从根节点到叶子节点的所有路径
 * Created by fpschina on 16/3/2.
 */
public class BinaryTreePaths {

    private String seperator = "->";

    /**
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // Write your code here
        List<String> result = new ArrayList<>();
        if (root != null) {
            findPaths("" + root.val, result, root);
        }
        return result;
    }

    public void findPaths(String tmp, List<String> result, TreeNode root) {
        TreeNode pLeft = root.left;
        TreeNode pRight = root.right;

        if (pLeft == null && pRight == null) {
            result.add(tmp);
        }

        if (pLeft != null) {
            findPaths(tmp + seperator + pLeft.val, result, pLeft);
        }
        if (pRight != null) {
            findPaths(tmp + seperator + pRight.val, result, pRight);
        }
    }
}


class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

