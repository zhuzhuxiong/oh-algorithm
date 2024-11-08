package com.labula.array.binary;

import java.util.Arrays;

/**
 * 查找排序数组第一个和最后一个元素
 *
 * @author zz
 */
public class No3Code34 {

    public int[] searchRange(int[] nums, int target) {
        int leftBound = leftBound(nums, target);
        int rightBound = rightBound(nums, target);
        return new int[]{leftBound, rightBound};
    }

    /**
     * 最左边界
     *
     * @param nums
     * @param target
     * @return
     */
    public static int leftBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        //[left, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                //当做右边界，向左逼近
                right = mid - 1;
            }
        }
        //判断是否越界
        if (left < 0 || left >= nums.length) {
            return -1;
        }

        return nums[left] == target ? left : -1;
    }

    /**
     * 最右边界
     *
     * @param nums
     * @param target
     * @return
     */
    public static int rightBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                left = mid + 1;
            }
        }
        if (right < 0 || right >= nums.length) {
            return -1;
        }
        return nums[right] == target ? right : -1;
    }


    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        No3Code34 code34 = new No3Code34();
        System.out.println(Arrays.toString(code34.searchRange(nums, 8)));
        System.out.println(Arrays.toString(code34.practice(nums, 8)));
    }


    public int[] practice(int[] nums, int target) {
        int left = left(nums, target);
        int right = right(nums, target);
        return new int[]{left, right};
    }

    public int left(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            }else if (nums[mid] > target) {
                right = mid - 1;
            }else if (nums[mid] == target) {
                right = mid - 1;
            }
        }
        if (left < 0 || left >= nums.length) {
            return -1;
        }
        return nums[left] == target ? left : -1;
    }

    public int right(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            }else if (nums[mid] > target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        if (left - 1 < 0 || left - 1 > nums.length) {
            return -1;
        }
        return nums[left - 1] == target ? left - 1 : -1;
    }
}
