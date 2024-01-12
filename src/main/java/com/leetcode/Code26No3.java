package com.leetcode;

import java.util.Arrays;

/**
 * 【数组】原地删除有序数组中的重复项
 * @author
 */
public class Code26No3 {

    public static int removeDuplicates(int[] nums) {
        int fast = 1, slow = 1;
        if (0 == nums.length) {
            return 0;
        }
        while (fast < nums.length) {
            if (nums[fast] != nums[fast-1]) {
                nums[slow] = nums[fast];
                slow ++;
            }
            fast++;
        }
        return slow;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        System.out.println(removeDuplicates(nums));
        System.out.println(practice(nums));
        System.out.println(Arrays.toString(nums));

        int[] nums1 = new int[]{1};
//        System.out.println(removeDuplicates(nums1));
        System.out.println(practice(nums1));
        System.out.println(Arrays.toString(nums1));
    }

    public static int practice(int[] nums) {
        return 0;
    }
}
