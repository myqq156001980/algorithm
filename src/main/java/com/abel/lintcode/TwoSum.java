package com.abel.lintcode;

import java.util.*;

/**
 * Created by sunzqc on 2017/8/29 09:58.
 * 给一个整数数组，找到两个数使得他们的和等于一个给定的数 target。
 * <p>
 * 你需要实现的函数twoSum需要返回这两个数的下标, 并且第一个下标小于第二个下标。注意这里下标的范围是 1 到 n，不是以 0 开头。
 * 样例
 * 给出 numbers = [2, 7, 11, 15], target = 9, 返回 [1, 2].
 * <p>
 * 挑战
 * Either of the following solutions are acceptable:
 * <p>
 * O(n) Space, O(nlogn) Time
 * O(n) Space, O(n) Time
 */
public class TwoSum {

    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        int left = 0, right = numbers.length - 1;
        int[] result = new int[2];
        Map<Integer, List<Integer>> positionMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (!positionMap.containsKey(numbers[i])) {
                ArrayList<Integer> tmp = new ArrayList<Integer>();
                tmp.add(i + 1);
                positionMap.put(numbers[i], tmp);
            } else {
                positionMap.get(numbers[i]).add(i + 1);
            }
        }
        Arrays.sort(numbers);
        while (left <= right) {
            if (numbers[left] + numbers[right] > target) {
                right--;
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {

                if (numbers[left] == numbers[right]) {
                    result[0] = positionMap.get(numbers[left]).get(0);
                    result[1] = positionMap.get(numbers[left]).get(1);
                } else {
                    result[0] = Math.min(positionMap.get(numbers[left]).get(0), positionMap.get(numbers[right]).get(0));
                    result[1] = Math.max(positionMap.get(numbers[left]).get(0), positionMap.get(numbers[right]).get(0));
                }

                break;
            }
        }
        return result;


    }
}
