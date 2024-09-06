package com.labula.backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列 II
 * @author zz
 */
public class No8Code47 {

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backtrack(nums);
        return res;
    }

    private void backtrack(int[] nums) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            track.add(nums[i]);
            used[i] = true;

            backtrack(nums);

            track.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
//        输入：nums = [1,1,2]
//        输出：[[1,1,2],[1,2,1],[2,1,1]]
        int[] nums = {1, 1, 2};
        No8Code47 code47 = new No8Code47();
        System.out.println(code47.permuteUnique(nums));
        System.out.println(code47.practice(nums));
    }

    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> tk = new LinkedList<>();
    boolean[] isUsed;
    public List<List<Integer>> practice(int[] nums) {
        Arrays.sort(nums);
        isUsed = new boolean[nums.length];
        bk(nums);
        return result;
    }

    private void bk(int[] nums) {
        if (tk.size() == nums.length) {
            result.add(new LinkedList<>(tk));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (isUsed[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !isUsed[i - 1]) {
                continue;
            }
            tk.add(nums[i]);
            isUsed[i] = true;

            bk(nums);

            tk.removeLast();
            isUsed[i] = false;
        }
    }
}
