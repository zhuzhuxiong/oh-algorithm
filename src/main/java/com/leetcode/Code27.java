package com.leetcode;

import java.util.Arrays;

/**
 * 【数组】原地移除数组中等于val的元素，返回新数组长度
 *
 * @author zz
 */
public class Code27 {

    public static int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }

    public static int removeElement1(int[] nums, int val) {
        int right = nums.length;
        int left = 0;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right-1];
                right--;
            }else {
                left++;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        System.out.println(removeElement(nums, 3));
        System.out.println(Arrays.toString(nums));

        int[] nums1 = {3, 2, 2, 3};
        System.out.println(removeElement1(nums1, 3));
        System.out.println(Arrays.toString(nums1));

        int[] nums2 = {3, 2, 2, 3};
        System.out.println(practice(nums2, 3));
        System.out.println(Arrays.toString(nums2));
    }

    public static int practice(int[] nums, int val) {
        int left = 0, right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right -1];
                right--;
            }else {
                left++;
            }
        }
        return left;
    }
}
