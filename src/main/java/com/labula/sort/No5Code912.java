package com.labula.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * fastSort
 * @author zz
 */
public class No5Code912 {

    public int[] sortArray(int[] nums) {
        //random
        shuffle(nums);
        //sort
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void shuffle(int[] nums) {
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            int k = i + random.nextInt(nums.length - i);
            swap(nums, i, k);
        }
    }

    private void sort(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return;
        }
        int p = partition(nums, lo, hi);
        sort(nums, lo, p - 1);
        sort(nums, p + 1, hi);
    }

    private int partition(int[] nums, int lo, int hi) {
        int p = nums[lo];
        int i = lo + 1, j = hi;
        while (i <= j) {
            while (i < hi && nums[i] <= p) {
                i++;
            }
            while (j > lo && nums[j] > p) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {5,1,1,2,0,0};
        No5Code912 code912 = new No5Code912();
        int[] res = code912.sortArray(nums);
        System.out.println(Arrays.toString(res));
    }
}
