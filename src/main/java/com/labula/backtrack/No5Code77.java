package com.labula.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * 组合（无重不复选）
 *
 * @author zz
 */
public class No5Code77 {

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k);
        return res;
    }

    private void backtrack(int start, int n, int k) {
        if (k == track.size()) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = start; i <= n; i++) {

            track.add(i);

            backtrack(i + 1, n, k);

            track.removeLast();
        }
    }

    public static void main(String[] args) {
//        输出：[[2,4],[3,4],[2,3],[1,2],[1,3],[1,4],]
        No5Code77 code77 = new No5Code77();
        System.out.println(code77.combine(4, 2));
        System.out.println(code77.practice(4, 2));
    }


    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> track1 = new LinkedList<>();

    public List<List<Integer>> practice(int n, int k) {
        bk(1, n, k);
        return result;
    }

    private void bk(int start, int n, int k) {
        if (track1.size() == k) {
            result.add(new LinkedList<>(track1));
        }

        for (int i = start; i <= n; i++) {
            track1.add(i);

            bk(i + 1, n, k);

            track1.removeLast();
        }
    }

}
