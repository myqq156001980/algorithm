package com.abel.lintcode;

import java.util.*;

/**
 * Created by sunzqc on 2017/8/10 16:41.
 * Design a data structure that supports all following operations in average O(1) time.
 *
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 * 您在真实的面试中是否遇到过这个题？ Yes
 * 样例
 * // Init an empty set.
 * RandomizedSet randomSet = new RandomizedSet();
 *
 * // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomSet.insert(1);
 *
 * // Returns false as 2 does not exist in the set.
 * randomSet.remove(2);
 *
 * // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomSet.insert(2);
 *
 * // getRandom should return either 1 or 2 randomly.
 * randomSet.getRandom();
 *
 * // Removes 1 from the set, returns true. Set now contains [2].
 * randomSet.remove(1);
 *
 * // 2 was already in the set, so return false.
 * randomSet.insert(2);
 *
 * // Since 2 is the only number in the set, getRandom always return 2.
 * randomSet.getRandom();*
 */
public class RandomizedSet {

    List<Integer> vals = new ArrayList<Integer>();
    Map<Integer, Integer> val2idx = new HashMap<Integer, Integer>();
    Random r = new Random();
    public RandomizedSet() {
        // do initialize if necessary
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already
     * contain the specified element.
     */
    public boolean insert(int val) {
        if (val2idx.containsKey(val)) {
            return false;
        } else {
            val2idx.put(val, val2idx.size());
            vals.add(val);
            return true;
        }
    }

    /**
     * Removes a value from the set. Returns true if the set contained the
     * specified element.
     */
    public boolean remove(int val) {
        if (!val2idx.containsKey(val)) {
            return false;
        } else {
            int idx = val2idx.remove(val);
            if (idx < vals.size() - 1) {// 若删除的不是链表最后的元素
                // 交换末尾元素和被删除元素
                vals.set(idx, vals.get(vals.size() - 1));
                val2idx.put(vals.get(vals.size() - 1), idx);
            }
            vals.remove(vals.size() - 1);
            return true;
        }
    }

    public int getRandom() {
        return vals.get(r.nextInt(vals.size()));
    }

}
