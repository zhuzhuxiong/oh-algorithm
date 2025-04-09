package com.labula.sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author
 */
public class No6SelectorSort {

    public void sort(int[] nums) {
        int n = nums.length;
        int split = 0;
        while (split < n) {
            int min = split;
            for (int i = split + 1; i < n; i++) {
                if (nums[i] < nums[min]) {
                    min = i;
                }
            }
            int tmp = nums[split];
            nums[split] = nums[min];
            nums[min] = tmp;
            split++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,9,2,8,3,7,4,6,5};
        new No6SelectorSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
