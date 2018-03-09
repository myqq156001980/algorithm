package com.abel.lintcode;

import java.util.*;

/**
 * Created by sunzqc on 2017/8/29 09:59.
 * 给出一个有n个整数的数组S，在S中找到三个整数a, b, c，找到所有使得a + b + c = 0的三元组。
 * <p>
 * 注意事项
 * <p>
 * 在三元组(a, b, c)，要求a <= b <= c。
 * <p>
 * 结果不能包含重复的三元组。
 * <p>
 * 您在真实的面试中是否遇到过这个题？ Yes
 * 样例
 * 如S = {-1 0 1 2 -1 -4}, 你需要返回的三元组集合的是：
 * <p>
 * (-1, 0, 1)
 * <p>
 * (-1, -1, 2)*
 */
public class ThreeSum {


    /*
    * @param numbers: Give an array numbers of n integer
    * @return: Find all unique triplets in the array which gives the sum of zero.
    */
    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here
        Set<List<Integer>> resultSet = new HashSet<>();

        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length - 2; i++) {
            int m = numbers[i];
            int sum = 0 - m;
            int left = i + 1;
            int right = numbers.length - 1;
            while (left < right) {
                if (numbers[left] + numbers[right] > sum) {
                    right--;
                } else if (numbers[left] + numbers[right] < sum) {
                    left++;
                } else {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(m);
                    tmp.add(numbers[left]);
                    tmp.add(numbers[right]);
                    resultSet.add(tmp);
                    left++;
                }
            }
        }
        return new ArrayList<>(resultSet);
    }
}
