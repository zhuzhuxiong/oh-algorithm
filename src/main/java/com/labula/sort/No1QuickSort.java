package com.labula.sort;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author zz
 */
public class No1QuickSort {

    public static void sort(int[] nums) {
        //打乱顺序
        shuffle(nums);
        //进行排序-原地
        sort(nums, 0, nums.length - 1);
    }

    private static void shuffle(int[] nums) {
        Random random = new Random();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            //r = [i, length - 1]的随机数
            int r = i + random.nextInt(length - i);
            swap(nums, i, r);
        }
    }

    /**
     * 框架-二叉树前序遍历
     * @param nums
     * @param low
     * @param high
     */
    private static void sort(int[] nums, int low, int high) {
        if (low > high) {
            return;
        }
        //核心-分隔nums[low--high]
        int p = partition(nums, low, high);

        sort(nums, low, p - 1);
        sort(nums, p + 1, high);
    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        // i,j定义：[low, i) <= pivot; (j, high] > pivot
        int i = low + 1, j = high;
        // i > j 结束
        while (i <= j) {
            while (i < high && nums[i] <= pivot) {
                i++;
                //此循环结束 nums[i] > pivot
            }
            while (j > low && nums[j] > pivot) {
                j--;
                //此循环结束 nums[j] <= pivot
            }
            // 此时 [lo, i) <= pivot && (j, hi] > pivot
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, low, j);
        return j;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public static void main(String[] args) {
        int[] nums = {9,5,6,3,2,4,7,5,3};
//        sort(nums);
        practice(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void practice(int[] nums) {
//        shufflePractice(nums);
//        sortPractice(nums, 0, nums.length - 1);
    }


}
