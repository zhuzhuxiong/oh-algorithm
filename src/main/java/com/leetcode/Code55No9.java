package com.leetcode;

/**
 * 【数组】 非负整数数组 nums ，最初位于nums[0] 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断能否到达最后一个下标，true or false 。
 *
 * @author zz
 */
public class Code55No9 {

    /**
     * 【贪心】
     */
    public static boolean canJump(int[] nums) {
        /** 最远可到达 */
        int maxDis = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= maxDis) {
                /** i + nums[i] 当前位置+还可以走的距离 */
                maxDis = Math.max(maxDis, i + nums[i]);
                if (maxDis >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 【动态规划】
     */
    public static boolean canJumpDp(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        if (0 == nums[0]) {
            return false;
        }

        int[] dp = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1], i+nums[i]);
            if (dp[i] >= nums.length-1) {
                return true;
            }
            if (dp[i] == i) {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        int[] nums1 = {3,2,1,0,4};
        System.out.println(canJump(nums));
        System.out.println(canJump(nums1));

        System.out.println(canJumpDp(nums));
        System.out.println(canJumpDp(nums1));
    }
}
