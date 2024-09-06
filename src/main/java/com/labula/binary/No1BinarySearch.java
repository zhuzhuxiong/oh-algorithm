package com.labula.binary;

/**
 * @author zz
 */
public class No1BinarySearch {

    /**
    int binarySearch(int[] nums, int target) {
        int left = 0, right = ...;

        while(...) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
            ...
            } else if (nums[mid] < target) {
                left = ...
            } else if (nums[mid] > target) {
                right = ...
            }
        }
        return ...;
    }
     */
    /**
     * base方法
     * @param nums
     * @param target
     * @return
     */
    int baseBinarySearch(int[] nums, int target) {
        int left  = 0;
        // 1 闭区间
        int right = nums.length - 1;
        // 2 带等于
        while (left <= right) {
            // 3
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] < target) {
                // 4
                left = mid + 1;
            }else if (nums[mid] > target) {
                // 5
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 最左边界
     * @param nums
     * @param target
     * @return
     */
    int leftBound(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        // 1
        int right = nums.length;
        // 2
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            }else if (nums[mid] < target) {
                left = mid + 1;
            }else if (nums[mid] > target) {
                // 3
                right = mid;
            }
        }
        // 4
        if (left == nums.length) {
            return -1;
        }
        // 5
        return nums[left] == target ? left : -1;
    }

    public static void main(String[] args) {

    }
}
