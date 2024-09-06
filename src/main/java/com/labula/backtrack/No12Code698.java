package com.labula.backtrack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 划分子集
 *
 * @author zz
 */
public class No12Code698 {

    /**
     * num视角
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean numView(int[] nums, int k) {
        //排除不符合的基本情况
        if (k > nums.length) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        //通过排序（大->小）可以多触发剪枝条件
        Arrays.sort(nums);
        //或者 i=0，j=nums.length；
        for (int i = 0; i < nums.length / 2; i++) {
            int tmp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = tmp;
        }

        //记录K个桶（子集）和
        int[] bucket = new int[k];
        // 每个子集和 = target
        int target = sum / k;
        return viewBacktrack(nums, 0, bucket, target);
    }

    private boolean viewBacktrack(int[] nums, int index, int[] bucket, int target) {
        if (index == nums.length) {
            //检查桶内结果
            for (int i = 0; i < bucket.length; i++) {
                if (bucket[i] != target) {
                    return false;
                }
            }
            return true;
        }

        for (int i = 0; i < bucket.length; i++) {
            //剪枝
            if (bucket[i] + nums[index] > target) {
                continue;
            }
            //回溯
            bucket[i] = bucket[i] + nums[index];
            if (viewBacktrack(nums, index + 1, bucket, target)) {
                return true;
            }
            bucket[i] = bucket[i] - nums[index];
        }
        return false;
    }

    /**
     * 桶视角
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k > nums.length) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        boolean[] used = new boolean[nums.length];
        int target = sum / k;
        return backtrack(k, 0, nums, 0, used, target);
    }
    // todo 位图

    Map<String, Boolean> memo = new HashMap<>();

    private boolean backtrack(int k, int bucket, int[] nums, int start, boolean[] used, int target) {
        if (k == 0) {
            return true;
        }
        //流程优化，减少重复情况的回溯
        String state = Arrays.toString(used);
        if (bucket == target) {
            boolean res = backtrack(k - 1, 0, nums, 0, used, target);
            memo.put(state, res);
            return res;
        }
        if (memo.containsKey(state)) {
            return memo.get(state);
        }
        for (int i = start; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (nums[i] + bucket > target) {
                continue;
            }

            bucket = bucket + nums[i];
            used[i] = true;

            if (backtrack(k, bucket, nums, i + 1, used, target)) {
                return true;
            }

            bucket = bucket - nums[i];
            used[i] = false;
        }
        return false;
    }


    public static void main(String[] args) {
//        输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
//        输出： True
//        说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        No12Code698 code698 = new No12Code698();
        System.out.println(code698.numView(nums, 4));
        System.out.println(code698.canPartitionKSubsets(nums, 4));
        System.out.println(code698.bucketPractice(nums, 4));
    }

    public boolean bucketPractice(int[] nums, int k) {
        if (k > nums.length) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        boolean[] used = new boolean[nums.length];
        return bk(k, 0, nums, 0, target, used);
    }

    Map<String,Boolean> memos = new HashMap<>();
    private boolean bk(int k, int bucket, int[] nums, int start, int target, boolean[] used) {
        if (k == 0) {
            return true;
        }
        String state = Arrays.toString(used);
        if (bucket == target) {
            boolean res = bk(k - 1, 0, nums, 0, target, used);
            memos.put(state,res);
            return res;
        }

        if (memos.containsKey(state)) {
            return memos.get(state);
        }

        for (int i = start; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (bucket + nums[i] > target) {
                continue;
            }
            bucket = bucket + nums[i];
            used[i] = true;

            if (bk(k, bucket, nums, i + 1, target, used)) {
                return true;
            }

            bucket = bucket - nums[i];
            used[i] = false;
        }
        return false;
    }
}
