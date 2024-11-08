package com.labula.array.binary;

/**
 * 二分查找
 *
 * @author zz
 */
public class No2Code704 {

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        No2Code704 code704 = new No2Code704();
        System.out.println(code704.search(nums, 9));
        System.out.println(code704.practice(nums, 9));
    }

    public int practice(int[] nums, int target) {
        return -1;
    }
}
