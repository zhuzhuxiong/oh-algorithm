package com.leetcode.classic150;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zz
 */
public class No46Code128 {

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                longest = Math.max(longest, currentStreak);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
        System.out.println(practice(nums));
    }

    public static int practice(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentSteak = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentSteak += 1;
                }
                longest = Math.max(longest, currentSteak);
            }
        }
        return longest;
    }
}
