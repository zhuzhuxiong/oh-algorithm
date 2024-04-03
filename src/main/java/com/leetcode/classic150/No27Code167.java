package com.leetcode.classic150;

import java.util.Arrays;

/**
 * @author
 */
public class No27Code167 {

    public static int[] twoSum(int[] numbers, int target) {
        // 双指针 头尾、左右；排序 控制单边+、-；
        int p1 = 0 , p2 = numbers.length - 1;
        while (p1 < p2) {
            if (numbers[p1] + numbers[p2] == target) {
                return new int[]{p1 + 1, p2 + 1};
            }else if (numbers[p1] + numbers[p2] < target){
                p1++;
            }else {
                p2--;
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }
}
