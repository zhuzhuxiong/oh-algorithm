package com.labula.array.intervals;

import java.util.Arrays;

/**
 * 1、排序：起点正序排列，起点相同-终点倒序排
 * 2、画图： 区间1：left=[0][0],right=[0][1] 区间2：[s,e]
 *      重合： left <= s && right >= e; (带等号)
 *      香蕉： right >= s && right <=e  (带等号)
 *      完全不想交：right < s            (不带等号)
 * @author zz
 */
public class No1Code1288 {

    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
               return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int left = intervals[0][0];
        int right = intervals[0][1];
        int res = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] ints = intervals[i];
            if (left <= ints[0] && right >= ints[1]) {
                res++;
            }
            if (right >= ints[0] && right <= ints[1]) {
                right = ints[1];
            }
            if (right < ints[0]) {
                left = ints[0];
                right = ints[1];
            }
        }
        return intervals.length - res;
    }

    public static void main(String[] args) {
        int[][] intervals =  {{1,4},{3,6},{2,8}};
        No1Code1288 code1288 = new No1Code1288();
        System.out.println(code1288.removeCoveredIntervals(intervals));
        System.out.println(code1288.practice(intervals));
    }

    public int practice(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int res = 0;
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] ints = intervals[i];
            if (left <= ints[0] && right >= ints[1]) {
                res++;
            }
            if (right >= ints[0] && right <= ints[1]) {
                right = ints[1];
            }
            if (right < ints[0]) {
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        return intervals.length - res;
    }
}
