package com.leetcode.classic150;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zz
 */
public class No45Code219 {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i],i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int[] nums1 = {1,2,3,1,2,3};
        System.out.println(practice(nums, 3));
        System.out.println(practice(nums1, 2));
    }

    public static boolean practice(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i],i);
        }
        return false;
    }
}
