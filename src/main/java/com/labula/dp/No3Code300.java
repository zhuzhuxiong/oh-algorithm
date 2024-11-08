package com.labula.dp;

import sun.java2d.pipe.RegionIterator;

import java.util.Arrays;

/**
 * 最长递增子序列
 *
 * @author zz
 */
public class No3Code300 {

    public int lengthOfLIS(int[] nums) {
        //状态转移方程  dp[i] 为 以nums[i]为结尾的子序列长度
        int[] dp = new int[nums.length];
        //base case dp 初始化为1；
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

    /**
     * 利用二分法
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {
        //牌堆最上层 数 的数组
        int[] top = new int[nums.length];
        //牌堆数
        int piles = 0;

        for (int i = 0; i < nums.length; i++) {
            //待处理的牌
            int poker = nums[i];

            //搜索左边界的二分查找
            int left = 0, right = piles;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (top[mid] > poker) {
                    right = mid;
                }else if (top[mid] < poker) {
                    left = mid + 1;
                }else {
                    right = mid;
                }
            }
            //没有合适牌堆 重开一堆
            if (left == piles) {
                piles++;
            }
            //牌置顶
            top[left] = poker;
        }
        //牌堆数 为最长子序列长度
        return piles;
    }


    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new No3Code300().lengthOfLIS(nums));
        System.out.println(new No3Code300().lengthOfLIS2(nums));
        System.out.println(new No3Code300().practice(nums));
    }

    public int practice(int[] nums) {
        int[] top = new int[nums.length];
        int piles = 0;

        for (int i = 0; i < nums.length; i++) {
            int poker = nums[i];
            int left = 0, right = piles;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (top[mid] > poker) {
                    right = mid;
                }else if(top[mid] < poker) {
                    left = mid + 1;
                }else {
                    right = mid;
                }
            }
            if (left == piles) {
                piles++;
            }
            top[left] = poker;
        }
        return piles;
    }
}
