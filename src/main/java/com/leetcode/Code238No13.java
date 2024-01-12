package com.leetcode;

import java.util.Arrays;

/**
 * 整数数组 nums，返回数组answer，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * @author zz
 */
public class Code238No13 {

    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];

        int[] left = new int[length];
        int[] right = new int[length];

        left[0] = 1;
        /** l[1] = l[0] * nums[0] */
        for (int i = 1; i < length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        right[length - 1] = 1;
        /** r[length-2] = l[length - 1] * nums[length - 1] */
        for (int i = length - 2; i >= 0 ; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < length; i++) {
            answer[i] = left[i] * right[i];
        }

        return answer;
    }

    public static int[] productExceptSelf1(int[] nums) {
        int length = nums.length;
        /** 既作为左侧乘机，又作为最终结果 */
        int[] answer = new int[length];

        answer[0] = 1;
        /** 作为左 */
        for (int i = 1; i < length; i++) {
            answer[i] = answer[i-1] * nums[i-1];
        }

        /** 右乘积总积 */
        int r = 1;
        for (int i = length - 1; i >= 0; i--) {
            /** 最终结果 左*右 */
            answer[i] = answer[i] * r;
            /** 右*当前数 */
            r = r * nums[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
        System.out.println(Arrays.toString(productExceptSelf1(nums)));
        int[] nums1 = {-1,1,0,-3,3};
        System.out.println(Arrays.toString(productExceptSelf(nums1)));
        System.out.println(Arrays.toString(productExceptSelf1(nums1)));

    }
}
