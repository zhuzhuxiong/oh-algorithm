package com.labula.linked;

import java.util.LinkedList;
import java.util.List;

/**
 * @author
 */
public class Test {

    static List<List<Integer>> res = new LinkedList<>();
    // 记录回溯算法的递归路径
    static LinkedList<Integer> track = new LinkedList<>();

    // 主函数
    public static List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k);
        return res;
    }

    static void backtrack(int start, int n, int k) {
        // base case
        if (k == track.size()) {
            // 遍历到了第 k 层，收集当前节点的值
            res.add(new LinkedList<>(track));
            return;
        }

        // 回溯算法标准框架
        for (int i = start; i <= n; i++) {
            // 选择
            track.addLast(i);
            // 通过 start 参数控制树枝的遍历，避免产生重复的子集
            backtrack(i + 1, n, k);
            // 撤销选择
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(combine(4, 3));
    }
}
