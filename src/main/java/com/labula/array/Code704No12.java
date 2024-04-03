package com.labula.array;

/**
 * @author
 */
public class Code704No12 {

    public static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            }else if (target > nums[mid]) {
                left = mid + 1;
            }else if (target < nums[mid]) {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int search = search(nums, 9);
        System.out.println(search);
    }
}
