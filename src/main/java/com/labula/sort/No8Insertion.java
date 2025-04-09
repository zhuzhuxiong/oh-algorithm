package com.labula.sort;

import java.util.Arrays;

/**
 * @author
 */
public class No8Insertion {

    public static void sort(int[] nums) {
        int n = nums.length;
        int split = 0;
        while (split < n) {
            for (int i = split; i > 0; i--) {
                if (nums[i] < nums[i - 1]) {
                    int tmp = nums[i];
                    nums[i] = nums[i- 1];
                    nums[i-1] = tmp;
                }else {
                    break;
                }
            }
            split++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,9,2,8,3,7,4,6,5};
        No8Insertion.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
