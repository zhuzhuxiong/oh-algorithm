package com.labula.array;

/**
 * @author zz
 */
public class Code167No8 {

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            }else if (sum > target) {
                right--;
            }else {
                left++;
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {

    }

    public static int[] practice(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left <= right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            }else if (sum > target) {
                right--;
            }else if (sum < target) {
                left++;
            }
        }
        return new int[]{};
    }
}
