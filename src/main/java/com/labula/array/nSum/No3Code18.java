package com.labula.array.nSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 *
 * @author zz
 */
public class No3Code18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
//        return nSumTarget(nums, 4, 0, target);
        return nSumPractice(nums, 4, 0, target);
    }

    /**
     *
     * @param nums
     * @param n
     * @param start
     * @param target 用long 解决范围超过int的问题
     * @return
     */
    private List<List<Integer>> nSumTarget(int[] nums, int n, int start, long target) {
        int length = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (n < 2 || length < n) {
            return res;
        }
        if (n == 2) {
            int lo = start, hi = length - 1;
            while (lo < hi) {
                long sum = (long) nums[lo] + nums[hi];
                int left = nums[lo], right = nums[hi];
                if (sum > target) {
                    while (lo < hi && nums[hi] == right) {
                        hi--;
                    }
                } else if (sum < target) {
                    while (lo < hi && nums[lo] == left) {
                        lo++;
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
        int[] nums = {1, 0, -1, 0, -2, 2};
        int[] nums1 = {1000000000,1000000000,1000000000,1000000000};
        No3Code18 code18 = new No3Code18();
        System.out.println(code18.fourSum(nums, 0));
//        System.out.println(code18.fourSum(nums1, -294967296));
    }

    private List<List<Integer>> nSumPractice(int[] nums, int n, int start, int target) {
        int length = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (n < 2 || length < n) {
            return res;
        }
        if (n == 2) {
            int lo = start, hi = length - 1;
            while (lo < hi) {
                int left = nums[lo], right = nums[hi];
                int sum = nums[lo] + nums[hi];
                if (target < sum) {
                    while (lo < hi && nums[hi] == right){
                        hi--;
                    }
                }else if (target > sum) {
                    while (lo < hi && nums[lo] == left) {
                        lo++;
                    }
                }else {
                    res.add(new ArrayList<>(Arrays.asList(left, right)));
                    while (lo < hi && nums[lo] == left) {
                        lo++;
                    }
                    while (lo < hi && nums[hi] == right){
                        hi--;
                    }
                }
            }
        }else {
            for (int i = start; i < length; i++) {
                List<List<Integer>> sub = nSumPractice(nums, n - 1, i + 1, target-nums[i]);
                for (List<Integer> list : sub) {
                    list.add(nums[i]);
                    res.add(list);
                }
                while (i < length - 1 && nums[i] == nums[i+1]) {
                    i++;
                }
            }
        }
        return res;
    }
}
