package com.labula.array.nSum;

import java.util.Arrays;

/**
 * 两数之和 二
 *
 * @author zz
 */
public class No4Code167 {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            }else if (numbers[left] + numbers[right] > target) {
                right--;
            }else {
                left++;
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        No4Code167 code167 = new No4Code167();
        System.out.println(Arrays.toString(code167.twoSum(nums, 9)));
    }
}
