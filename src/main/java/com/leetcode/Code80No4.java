package com.leetcode;

import java.util.Arrays;

/**
 * 【数组】删除数组中的重复项【重复次数超过两次的】
 *
 * @author zzx
 */
public class Code80No4 {

    public static int removeDuplicates(int[] nums) {
        int k = 2;
        if (k >= nums.length) {
            return nums.length;
        }
        int fast = k, slow = k;
        for (int i = k; i < nums.length ; i++) {
            if (nums[slow -k] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

        int[] nums1 = new int[]{1};
        System.out.println(removeDuplicates(nums1));
        System.out.println(Arrays.toString(nums1));
    }

    public static int practice(int[] nums) {

       return 0;
    }
}
