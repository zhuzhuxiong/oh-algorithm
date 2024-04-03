package com.leetcode.classic150;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 【数组】轮转数组
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 *
 * @author zz
 */
public class No6Code189 {

    /**
     * 【方法1】额外空间，额外数组；
     * (i + k) % nums.length = i
     */
    public static void rotate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(i, nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[(i + k) % nums.length] = map.get(i);
        }
    }

    /***
     * 【方法2】 多次反转，先整体反转，在反转前k个，最后反转后k个
     */
    public static void rotate1(int[] nums, int k) {
        k = k % nums.length;
        revise(nums, 0, nums.length - 1);
        revise(nums, 0, k - 1);
        revise(nums, k, nums.length - 1);
    }

    public static void revise(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = tmp;
        }
    }

    /**
     * 【方法3】原地换位 todo
     */
    public static void rotate2(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int i = 0; count < nums.length; i++) {
            int cur = i;
            int curNum = nums[cur];
            do {
                int next = (cur + k) % nums.length;
                int tmp = nums[next];
                nums[next] = curNum;
                curNum = tmp;
                cur = next;

                count++;
            } while (i != cur);
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));

        int[] nums1 = {1, 2, 3, 4, 5, 6};
        rotate1(nums1, 3);
        System.out.println(Arrays.toString(nums1));

        int[] nums2 = {1, 2, 3, 4, 5, 6};
        rotate1(nums2, 3);
        System.out.println(Arrays.toString(nums2));
    }
}
