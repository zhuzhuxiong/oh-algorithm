package com.leetcode;

/**
 * 【数组】
 *
 * @author zz
 */
public class Code45No10 {

    public static int jump(int[] nums) {
        /** 起跳点 */
        int start = 0;
        /** 某次起跳结束点 */
        int end = 1;
        int ans = 0;
        /** 未到终点 */
        while (end < nums.length) {
            /** 最远距离 */
            int maxPos = 0;
            /** 找起跳范围内，下次起跳的最远距离 */
            for (int i = start; i < end; i++) {
                maxPos = Math.max(maxPos, i + nums[i]);
            }
            /** 交换下次起跳位置 和 终点 */
            start = end;
            end = maxPos + 1;
            ans++;
        }
        return ans;
    }

    public static int jump1(int[] nums) {
        int end = 0;
        int position = 0;
        int step = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            position = Math.max(position, nums[i] + i);
            if (i == end) {
                end = position;
                step++;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jump(nums));
        System.out.println(jump1(nums));
    }

    public static int practice(int[] nums) {
        int start = 0;
        int end = 1;
        int ans = 0;
        while (end < nums.length) {
            int maxDis = 0;
            for (int i = start; i < end; i++) {
                maxDis = Math.max(maxDis, i + nums[i]);
            }
            start = end;
            end = maxDis + 1;
            ans++;
        }
        return ans;
    }
}
