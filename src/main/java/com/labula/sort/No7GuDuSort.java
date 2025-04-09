package com.labula.sort;

import java.util.Arrays;

/**
 * @author
 */
public class No7GuDuSort {

    public static void sort(int[] nums) {
        int n = nums.length;
        int split = 0;
        while (split < n) {
            boolean flag = false;
            for (int i = n - 1; i > split; i--) {
                if (nums[i] < nums[i - 1]){
                    int tmp = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = tmp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
            split++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,9,2,8,3,7,4,6,5};
        No7GuDuSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
