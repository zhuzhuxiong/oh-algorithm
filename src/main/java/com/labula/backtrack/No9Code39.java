package com.labula.backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 子集III--组合总和
 *
 * @author zz
 */
public class No9Code39 {


    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int trackSum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (null == candidates) {
            return res;
        }
        backtrack(candidates, 0, target);
        return res;
    }

    private void backtrack(int[] candidates, int start, int target) {
        if (target == trackSum) {
            res.add(new LinkedList<>(track));
            return;
        }

        if (trackSum > target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            track.add(candidates[i]);
            trackSum = trackSum + candidates[i];

            backtrack(candidates, i, target);

            track.removeLast();
            trackSum = trackSum - candidates[i];
        }
    }

    public static void main(String[] args) {
//        candidates = [2,3,6,7], target = 7
//        输出：[[2,2,3],[7]]
        int[] candidates = {2, 3, 6, 7};
        No9Code39 code39 = new No9Code39();
        System.out.println(code39.combinationSum(candidates, 7));
        System.out.println(code39.practice(candidates, 7));
    }

    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> tk = new LinkedList<>();
    int tkSum = 0;
    public List<List<Integer>> practice(int[] candidates, int target) {
        bk(candidates, 0, target);
        return result;
    }

    private void bk(int[] candidates, int start, int target) {
        if (tkSum == target) {
            result.add(new LinkedList<>(tk));
            return;
        }

        if (tkSum > target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            tk.add(candidates[i]);
            tkSum = tkSum + candidates[i];

            bk(candidates, i, target);

            tk.removeLast();
            tkSum = tkSum - candidates[i];
        }
    }


}
