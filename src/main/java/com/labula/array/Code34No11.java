package com.labula.array;

import javax.swing.table.TableRowSorter;

/**
 * @author zz
 */
public class Code34No11 {

    public static int baseBinarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        //[left, right]
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] < target) {
                left = mid + 1;
            }else if (nums[mid] > target) {
                right = mid - 1;
            }else if (nums[mid] == target){
                //直接返回
                return mid;
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
    public static int leftBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        //[left, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            }else if (nums[mid] > target) {
                right = mid - 1;
            }else if (nums[mid] == target) {
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
     * @param nums
     * @param target
     * @return
     */
    public static int rightBound(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            }else if (nums[mid] < target) {
                left = mid + 1;
            }else if (nums[mid] == target) {
                left = mid + 1;
            }
        }
        if (right < 0 || right >= nums.length) {
            return -1;
        }
        return nums[right] == target ? right : -1;
    }

    public static int[] searchRange(int[] nums, int target) {
        int leftBound = leftBound(nums, target);
        int rightBound = rightBound(nums, target);
        return new int[]{leftBound,rightBound};
    }

}
