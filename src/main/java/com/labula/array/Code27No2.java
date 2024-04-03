package com.labula.array;

import java.util.Arrays;

/**
 * @author zz
 */
public class Code27No2 {

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            //用fast判断
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        System.out.println(practice(nums, 3));
        System.out.println(Arrays.toString(nums));
    }

    public static int practice(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
