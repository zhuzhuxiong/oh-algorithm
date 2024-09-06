package com.labula.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 * @author zz
 */
public class No1Code46 {

    /**结果集*/
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        /** 【路径】*/
        LinkedList<Integer> track = new LinkedList<>();
        /** 配合nums 构成【选择列表】 */
        boolean[] used = new boolean[nums.length];
        /** 回溯 */
        backtrack(nums, track, used);
        return res;
    }

    void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
        /** 结束条件：路径包含所有元素 */
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        /** 回溯的前序、后序 在循环内部 */
        for (int i = 0; i < nums.length; i++) {
            /** 元素被使用，跳过 */
            if (used[i]) {
                continue;
            }
            /** 做选择 */
            track.add(nums[i]);
            used[i] = true;
            backtrack(nums, track, used);
            /** 撤销选择 */
            track.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
//        输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
        int[] nums = {1,2,3};
        No1Code46 code46 = new No1Code46();
        List<List<Integer>> permute = code46.permute(nums);
        System.out.println(permute);

        System.out.println(code46.practice(nums));
    }


    List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> practice(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        bk(nums, track, used);
        return result;
    }

    private void bk(int[] nums, LinkedList<Integer> track, boolean[] used) {
        if (track.size() == nums.length) {
            result.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            track.add(nums[i]);
            used[i] = true;

            bk(nums, track, used);

            track.removeLast();
            used[i] = false;
        }
    }


}
