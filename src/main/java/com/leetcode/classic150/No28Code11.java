package com.leetcode.classic150;

/**
 * @author zz
 */
public class No28Code11 {

    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(area, ans);
            if (height[left] < height[right]) {
                left ++;
            }else {
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int[] height1 = {1,1};
        System.out.println(maxArea(height));
        System.out.println(maxArea(height1));
    }
}
