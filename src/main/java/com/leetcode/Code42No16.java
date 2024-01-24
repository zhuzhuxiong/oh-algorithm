package com.leetcode;

/**
 * @author
 */
public class Code42No16 {

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
    }
}
