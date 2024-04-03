package com.leetcode.classic150;

/**
 * @author
 */
public class No16Code42 {

    public static int trap(int[] height) {
        int length = height.length;
        if (length == 0) {
            return 0;
        }
        int[] leftMax = new int[length];
        leftMax[0] = height[0];
        for (int i = 1; i < length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[length];
        rightMax[length - 1] = height[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < length; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] h1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] h2 = {4, 2, 0, 3, 2, 5};
        System.out.println(trap(h1));
        System.out.println(trap(h2));

        System.out.println(practice(h1));
        System.out.println(practice(h2));
    }

    public static int practice(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        left[0] = height[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i-1],height[i]);
        }

        int[] right = new int[n];
        right[n - 1] = height[n-1];
        for (int i = n-2; i >=0; i--) {
            right[i] = Math.max(right[i+1],height[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(left[i], right[i]) - height[i];
        }
        return ans;
    }
}
