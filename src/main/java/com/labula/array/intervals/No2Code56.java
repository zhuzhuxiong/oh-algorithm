package com.labula.array.intervals;

import com.util.PrintUtil;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author zz
 */
public class No2Code56 {

    public int[][] merge(int[][] intervals) {
        //1、排序
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });

        LinkedList<int[]> list = new LinkedList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            int[] last = list.getLast();

            if (last[1] >= cur[0]) {
                last[1] = Math.max(last[1], cur[1]);
            }else {
                list.add(cur);
            }
        }
        return list.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        No2Code56 code56 = new No2Code56();
        PrintUtil.printMatrix1(code56.merge(intervals));
        PrintUtil.printMatrix1(code56.practice(intervals));
    }

    public int[][] practice(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });

        LinkedList<int[]> list = new LinkedList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            int[] last = list.getLast();
            if (last[1] >= curr[0]) {
                last[1] = Math.max(last[1], curr[1]);
            }else {
                list.add(intervals[i]);
            }
        }
        return list.toArray(new int[0][0]);
    }
}
