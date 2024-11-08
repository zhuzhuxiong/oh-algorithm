package com.labula.array.binary;

/**
 * @author zz
 */
public class No1BinarySearch {

    /**
     * 1、right 定义 决定区间开闭
     * 2、循环判断
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
     * 最左边界 开区间 [left, right)
     * 如果 target 不存在，搜索左侧边界的二分搜索返回的索引是大于 target 的最小索引。
     * @param nums
     * @param target
     * @return
     */
    int leftBoundOpen(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        // 1 开区间
        int right = nums.length;
        // 2 <
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
        // 4 判断越界
        if (left < 0 || left >= nums.length) {
            return -1;
        }
        // 5 判断是否找到目标值
        return nums[left] == target ? left : -1;
    }

    /**
     * 最左边界-闭区间
     * @param nums
     * @param target
     * @return
     */
    int leftBoundClose(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            }else if (nums[mid] > target) {
                right = mid - 1;
            }else if (nums[mid] == target) {
                //收缩右边界
                right = mid - 1;
            }
        }
        if (left < 0 || left >= nums.length) {
            return -1;
        }

        return nums[left] == target ? left : -1;
    }


    /**
     * 最右边界-开区间
     * 如果 target 不存在，搜索右侧边界的二分搜索返回的索引是小于 target 的最大索引。
     * @param nums
     * @param target
     * @return
     */
    int rightBoundOpen(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                //找到最右的关键
                left = mid + 1;
            }else if (nums[mid] < target) {
                left = mid + 1;
            }else if (nums[mid] > target) {
                //不减一
                right = mid;
            }
        }
        // 正常是返回left - 1,所以都用left-1做判断。
        if (left - 1 < 0 || left - 1 > nums.length) {
            return -1;
        }
        return nums[left - 1] == target ? left - 1 : -1;
    }

    /**
     * 最右边界-闭区间
     * @param nums
     * @param target
     * @return
     */
    int rightBoundClose(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            }else if (nums[mid] > target) {
                right = mid - 1;
            }else if (nums[mid] == target) {
                left = mid + 1;
            }
        }
        if (left - 1 < 0 || left - 1 > nums.length) {
            return -1;
        }
        return nums[left - 1] == target ? left - 1 : -1;
    }
    

    public static void main(String[] args) {

    }
}
