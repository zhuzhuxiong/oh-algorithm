package com.labula.backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和 II
 * @author zz
 */
public class No7Code40 {

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int count = 0;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, 0, target);
        return res;
    }

    private void backtrack(int[] candidates, int start, int target) {
        if (target == count) {
            res.add(new LinkedList<>(track));
            return;
        }
        if (count > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i-1]){
                continue;
            }

            track.add(candidates[i]);
            count = count + candidates[i];

            backtrack(candidates, i + 1, target);

            track.removeLast();
            count = count - candidates[i];
        }
    }

    public static void main(String[] args) {
//        输入: candidates = [10,1,2,7,6,1,5], target = 8,
//        输出:[[1,1,6],[1,2,5],[1,7],[2,6]]
        int[] candidates = {10,1,2,7,6,1,5};
        No7Code40 code40 = new No7Code40();
        System.out.println(code40.combinationSum2(candidates, 8));
        System.out.println(code40.practice(candidates, 8));
    }

    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> tk = new LinkedList<>();
    int tkSum = 0;
    public List<List<Integer>> practice(int[] candidates, int target) {
        if (null == candidates) {
            return result;
        }
        Arrays.sort(candidates);
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
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            tk.add(candidates[i]);
            tkSum = tkSum + candidates[i];

            bk(candidates, i + 1, target);

            tk.removeLast();
            tkSum = tkSum - candidates[i];
        }
    }
}
