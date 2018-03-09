package com.abel.lintcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sunzqc on 2017/8/16 13:55.
 * 在上次打劫完一条街道之后和一圈房屋之后，窃贼又发现了一个新的可以打劫的地方，但这次所有的房子组成的区域比较奇怪，聪明的窃贼考察地形之后，发现这次的地形是一颗二叉树。与前两次偷窃相似的是每个房子都存放着特定金额的钱。你面临的唯一约束条件是：相邻的房子装着相互联系的防盗系统，且当相邻的两个房子同一天被打劫时，该系统会自动报警。
 *
 * 算一算，如果今晚去打劫，你最多可以得到多少钱，当然在不触动报警装置的情况下。
 *
 * 您在真实的面试中是否遇到过这个题？ Yes
 * 样例
 *   3
 *  / \
 * 2   3
 *  \   \
 *   3   1
 * 窃贼最多能偷窃的金钱数是 3 + 3 + 1 = 7.
 *
 *     3
 *    / \
 *   4   5
 *  / \   \
 * 1   3   1
 * 窃贼最多能偷窃的金钱数是 4 + 5 = 9.*
 */
public class HouseRobber3 {


    /*
    * @param root: The root of binary tree.
    * @return: The maximum amount of money you can rob tonight
    */
    Map<TreeNode, Integer> M = new HashMap<TreeNode, Integer>();

    public int houseRobber3(TreeNode root) {
        // write your code here
        if (root == null)
            return 0;
        if (M.containsKey(root))
            return M.get(root);
        /*加了这段就有错。。。莫非这中间还能有负数。。。不懂
        if(root.left==null&&root.right==null)
            return root.val;
        */
        //rob
        int rob = root.val;
        if (root.left != null) {
            rob += houseRobber3(root.left.left);
            rob += houseRobber3(root.left.right);
        }
        if (root.right != null) {
            rob += houseRobber3(root.right.left);
            rob += houseRobber3(root.right.right);
        }

        int noRob = houseRobber3(root.left) + houseRobber3(root.right);
        M.put(root, Math.max(rob, noRob));
        return Math.max(rob, noRob);
    }
}
