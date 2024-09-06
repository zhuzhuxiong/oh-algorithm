package com.labula.backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 子集 II
 * @author zz
 */
public class No6Code90 {

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int start) {
        res.add(new LinkedList<>(track));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }

            track.add(nums[i]);

            backtrack(nums, i + 1);

            track.removeLast();
        }
    }

    public static void main(String[] args) {
//        输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
        int[] nums = {1, 2, 2};
        No6Code90 code90 = new No6Code90();
        System.out.println(code90.subsetsWithDup(nums));
        System.out.println(code90.practice(nums));
    }

    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> tk = new LinkedList<>();
    public List<List<Integer>> practice(int[] nums) {
        Arrays.sort(nums);
        bk(nums, 0);
        return result;
    }

    private void bk(int[] nums, int start) {
        result.add(new LinkedList<>(tk));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            tk.add(nums[i]);
            bk(nums, i + 1);
            tk.removeLast();
        }
    }

}
