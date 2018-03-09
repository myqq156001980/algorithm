package com.abel.lintcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by sunzqc on 2017/8/10 13:26.
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?\
 * 样例
 * Given n = 2, prerequisites = [[1,0]]
 * Return true
 *
 * Given n = 2, prerequisites = [[1,0],[0,1]]
 * Return false
 */
public class CourseSchedule {

    /**
     * @param numCourses a total of n courses
     * @param prerequisites a list of prerequisite pairs
     * @return true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Write your code here
        List<List<Integer>> posts = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            posts.add(new ArrayList<Integer>());
        }

        int[] preNums = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            posts.get(prerequisites[i][1]).add(prerequisites[i][0]); // 记录每个先决条件下，后面可以进行的步骤
            preNums[prerequisites[i][0]]++; // 先决条件个数
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (preNums[i] == 0) {
                queue.offer(i); // 将没有先决条件的步骤加入FIFO队列
            }
        }

        int count = numCourses;
        // 没有先决条件的队列不为空时
        while (!queue.isEmpty()) {
            int cur = queue.poll(); // 获取没有先决条件的步骤
            // posts.get(cur) 获取没有先决条件的步骤被其他步骤依赖的列表 posts.get(cur) ->依赖于 cur 的完成
            for (int i : posts.get(cur)) {
                // 由于cur为 i 步骤的先决条件, 执行了cur 所以i的先决条件数量应该-1 --preNums[i]
                if (--preNums[i] == 0) {
                    queue.offer(i); // 当先决条件的数据减少到0时,加油不需要先决条件既可以执行的队列
                }
            }
            count--; // 成功执行了一个步骤count -1 当所有步骤执行完毕则 count应该为0
        }

        return count == 0;
    }
}
