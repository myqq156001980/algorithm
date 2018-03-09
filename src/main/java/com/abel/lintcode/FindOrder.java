package com.abel.lintcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by sunzqc on 2017/8/10 13:37.
 * 你需要去上n门九章的课才能获得offer，这些课被标号为 0 到 n-1 。
 * 有一些课程需要“前置课程”，比如如果你要上课程0，你需要先学课程1，我们用一个匹配来表示他们： [0,1]
 *
 * 给你课程的总数量和一些前置课程的需求，返回你为了学完所有课程所安排的学习顺序。
 *
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 * 样例
 * 给定 n = 2, prerequisites = [[1,0]]
 * 返回 [0,1]
 *
 * 给定 n = 4, prerequisites = [1,0],[2,0],[3,1],[3,2]]
 * 返回 [0,1,2,3] or [0,2,1,3]
 */
public class FindOrder {


    /**
     * @param numCourses    a total of n courses
     * @param prerequisites a list of prerequisite pairs
     * @return the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Write your code here
        int[] result = new int[numCourses]; // 结果顺序数组
        List<List<Integer>> posts = new ArrayList<>(); //条件保存列表
        for (int i = 0; i < numCourses; i++) {
            posts.add(new ArrayList<Integer>()); //初始化
        }

        int[] preNums = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            posts.get(prerequisites[i][1]).add(prerequisites[i][0]); // 加入先决条件后可以执行的课程
            preNums[prerequisites[i][0]]++; // 课程的先决条件数量加1
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (preNums[i] == 0) {
                queue.offer(i); // 将没有先决条件就可以执行的课程 加入队列
            }
        }

        int count = numCourses; // 课程总数
        int index = 0;
        // 如果可以执行的课程队列不为空
        while (!queue.isEmpty()) {
            int cur = queue.poll(); // 取出可以执行的课程
            result[index++] = cur;  // 将此课程加入结果顺序数组
            for (int i : posts.get(cur)) {  // 获取当前执行的课程后续可以执行的课程列表
                if (--preNums[i] == 0) {    // 后续可以执行的课程的先决条件-1
                    queue.offer(i); // 如果后续可以执行的课程的先决条件降为0加入可以执行的队列
                }
            }
            count--; // 总的课程数-1
        }

        if (count != 0) {   // 如果没有执行所有的课程,既课程数没有降低到0 返回空数组
            return new int[0];
        }
        // 如果都执行过,返回顺序列表
        return result;
    }
}
