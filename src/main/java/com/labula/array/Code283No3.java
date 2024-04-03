package com.labula.array;

import java.util.Arrays;

/**
 * @author zz
 */
public class Code283No3 {

    public static void moveZeroes(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        practice(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void practice(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }

    }
}
