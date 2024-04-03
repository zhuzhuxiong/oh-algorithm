package com.leetcode.classic150;

import java.util.*;

/**
 * @author zz
 */
public class No12Code380 {
    List<Integer> nums;
    Map<Integer, Integer> map;
    Random random;

    public No12Code380() {
        nums = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        int index = nums.size();
        nums.add(val);
        map.put(val, index);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        Integer index = map.get(val);
        Integer last = nums.get(nums.size() - 1);
        nums.set(index, last);
        nums.remove(nums.size() - 1);
        map.put(last, index);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int i = random.nextInt(nums.size());
        return nums.get(i);
    }

    public static void main(String[] args) {

    }
}
