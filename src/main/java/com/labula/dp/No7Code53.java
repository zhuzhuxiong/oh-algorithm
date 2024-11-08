package com.labula.dp;

/**
 * 最大子数组和
 *
 * @author zz
 */
public class No7Code53 {

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        // 以nums[i] 结尾的 和
        int[] dp = new int[n];

        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int maxSubArrayZip(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int dp0 = nums[0];
        int dp1 = 0, res = dp0;
        for (int i = 1; i < n; i++) {
            dp1 = Math.max(nums[i], dp0 + nums[i]);
            dp0 = dp1;
            res = Math.max(res, dp1);
        }
        return res;
    }

    public static void main(String[] args) {
//        输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//        输出：6
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        No7Code53 code53 = new No7Code53();
        System.out.println(code53.maxSubArray(nums));
        System.out.println(code53.maxSubArrayZip(nums));
        System.out.println(code53.practice(nums));
    }


    public int practice(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
