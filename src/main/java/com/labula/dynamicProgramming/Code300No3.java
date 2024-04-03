package com.labula.dynamicProgramming;

import java.util.Arrays;

/**
 * @author zz
 */
public class Code300No3 {

    public int lengthOfLIS(int[] nums) {
        //dp[i] 表示以nums[i] 为结尾的子序列长度 [1, 1, 1, 2, 2, 3, 4, 4]
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

//    public int lengthOfLIS1(int[] nums){
//
//    }



    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new Code300No3().lengthOfLIS(nums));
    }
}
