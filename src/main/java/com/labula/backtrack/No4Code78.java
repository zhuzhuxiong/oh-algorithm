package com.labula.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * 子集（无重不复选）
 * @author zz
 */
public class No4Code78 {

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int start) {

        res.add(new LinkedList<>(track));

        for (int i = start; i < nums.length; i++) {
            track.addLast(nums[i]);

            backtrack(nums, i + 1);

            track.removeLast();
        }
    }

    public static void main(String[] args) {
//        输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
        int[] nums = {1,2,3};
        No4Code78 code78 = new No4Code78();
        System.out.println(code78.subsets(nums));
        System.out.println(code78.practice(nums));
    }


    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> track1 = new LinkedList<>();
    public List<List<Integer>> practice(int[] nums) {
        bk(nums, 0);
        return result;
    }

    private void bk(int[] nums, int start) {
        result.add(new LinkedList<>(track1));

        for (int i = start; i < nums.length; i++) {
            track1.add(nums[i]);

            bk(nums, i + 1);

            track1.removeLast();
        }
    }
}
