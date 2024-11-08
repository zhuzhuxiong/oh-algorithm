package com.labula.array.preSum;

/**
 * 前缀和：区域和检索
 * @author zz
 */
public class No1Code303 {

    private int[] preSum;

    public No1Code303(int[] nums) {
        //前缀和数组
        preSum = new int[nums.length + 1];
        //preSum[0] = 0
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        /** old method 击败5.21% */
//        int res = 0;
//        for (int i = left; i <= right; i++) {
//            res += nums[i];
//        }
//        return res;
        return preSum[right + 1] - preSum[left];
    }

    public static void main(String[] args) {
//        输入：["NumArray", "sumRange", "sumRange", "sumRange"]
//             [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
//        输出：[null, 1, -1, -3]

        No1Code303 code303 = new No1Code303(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(code303.sumRange(0, 2));
        System.out.println(code303.sumRange(2, 5));
        System.out.println(code303.sumRange(0, 5));
    }

    public No1Code303(int[] nums, int x) {
        preSum = new int[nums.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
    }

    public int practice(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }
}
