package com.labula.dp;

import java.util.Arrays;

/**
 * 俄罗斯套娃信封(二维-->一维-最长递增子序列)
 *
 * @author zz
 */
public class No4Code354 {


    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, (a, b) -> {
            return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
        });

        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = envelopes[i][1];
        }
        return lengthOfLIS(height);
    }

    private int lengthOfLIS(int[] nums) {
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

    public static void main(String[] args) {
        int[][] envelopes1 = {{30, 50}, {12, 2}, {3, 4}, {12, 15}};
        int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        No4Code354 code354 = new No4Code354();
//        System.out.println(code354.maxEnvelopes(envelopes));
//        System.out.println(code354.practice(envelopes));

        System.out.println(code354.maxEnvelopes(envelopes1));
        System.out.println(code354.practice(envelopes1));
    }

    public int practice(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
        });
        int[] height = new int[envelopes.length];
        for (int i = 0; i < height.length; i++) {
            height[i] = envelopes[i][1];
        }

        int[] top = new int[height.length];
        int piles = 0;

        for (int i = 0; i < height.length; i++) {
            int poker = height[i];
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
            if (left == piles) {
                piles++;
            }
            top[left] = poker;
        }
        return piles;
    }

}
