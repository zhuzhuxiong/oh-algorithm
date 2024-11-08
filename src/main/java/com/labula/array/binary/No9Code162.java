package com.labula.array.binary;

/**
 * 选择峰值
 *
 * @author zz
 */
public class No9Code162 {

    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            //如果 m 较大，则左侧存在峰值，如果 m + 1 较大，则右侧存在峰值
            if (nums[mid] >= nums[mid + 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
//        输入：nums = [1,2,1,3,5,6,4]
//        输出：1 或 5

        int[] nums = {1,2};
        No9Code162 code = new No9Code162();
        System.out.println(code.findPeakElement(nums));
    }
}
