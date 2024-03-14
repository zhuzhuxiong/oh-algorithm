package com.leetcode;

import com.util.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zz
 */
public class Code56No48 {

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[][]{};
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int l = intervals[i][0], r = intervals[i][1];
            if (list.size() == 0 || list.get(list.size() - 1)[1] < l) {
                list.add(new int[]{l, r});
            }else {
                list.get(list.size() - 1)[1] = Math.max(r, list.get(list.size() - 1)[1]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        PrintUtil.printMatrix1(merge(intervals));
    }

    public static int[][] practice(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int l = intervals[i][0], r = intervals[i][1];
            if (list.size() == 0 || list.get(list.size() - 1)[1] < l) {
                list.add(new int[]{l,r});
            }else {
                list.get(list.size() - 1)[1] = Math.max(r, list.get(list.size() - 1)[1]);//
            }
        }
        return list.toArray(new int[list.size()][]);//
    }
}
