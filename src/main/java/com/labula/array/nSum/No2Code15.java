package com.labula.array.nSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 *
 * @author z
 */
public class No2Code15 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return nSumTarget(nums, 3, 0, 0);
    }

    /**
     * nSum 通用方法
     *
     * @param nums   数组
     * @param n      几数和 本题：3
     * @param start  开始位置
     * @param target 加和结果，本题0；
     * @return
     */
    private List<List<Integer>> nSumTarget(int[] nums, int n, int start, int target) {
        int length = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (n < 2 || length < n) {
            return res;
        }
        if (n == 2) {
            int lo = start, hi = length - 1;
            while (lo < hi) {
                int sum = nums[lo] + nums[hi];
                int left = nums[lo], right = nums[hi];
                if (sum < target) {
                    while (lo < hi && nums[lo] == left) {
                        lo++;
                    }
                } else if (sum > target) {
                    while (lo < hi && nums[hi] == right) {
                        hi--;
                    }
                } else {
                    res.add(new ArrayList<>(Arrays.asList(left, right)));
                    while (lo < hi && nums[lo] == left) {
                        lo++;
                    }
                    while (lo < hi && nums[hi] == right) {
                        hi--;
                    }
                }

            }
        } else {
            for (int i = start; i < length; i++) {
                List<List<Integer>> sub = nSumTarget(nums, n - 1, i + 1, target - nums[i]);
                for (List<Integer> list : sub) {
                    list.add(nums[i]);
                    res.add(list);
                }
                while (i < length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        int[] nums1 = {0,1,1};
        No2Code15 code15 = new No2Code15();
        System.out.println(code15.threeSum(nums));
        System.out.println(code15.threeSum(nums1));
    }
}
