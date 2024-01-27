package com.leetcode;

/**
 * 滑动窗口
 * @author zz
 */
public class Code209No30 {


    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int start = 0, end = 0;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        while (end < n) {
            sum = sum + nums[end];
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum = sum - nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0: ans;
    }

    public static int minSubArrayLen1(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum = sum + nums[j];
                if (sum >= target) {
                    ans = Math.min(ans,j-i+1);
                    break;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        int[] n1 = {2,3,1,2,4,3};
        int[] n2 = {1,4,4};
        int[] n3 = {1,1,1,1,1,1,1,1};

        System.out.println(minSubArrayLen(7, n1));
        System.out.println(minSubArrayLen(4, n2));
        System.out.println(minSubArrayLen(11, n3));

        System.out.println("--------------");

        System.out.println(minSubArrayLen1(7, n1));
        System.out.println(minSubArrayLen1(4, n2));
        System.out.println(minSubArrayLen1(11, n3));
    }

}
