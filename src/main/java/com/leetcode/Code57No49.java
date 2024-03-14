package com.leetcode;

import com.util.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zz
 */
public class Code57No49 {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] ints = new int[intervals.length + 1][2];
        for (int i = 0; i < intervals.length; i++) {
            ints[i] = intervals[i];
        }
        ints[ints.length - 1] = newInterval;

        Arrays.sort(ints,(a,b) -> a[0] - b[0]);
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < ints.length; i++) {
            int l = ints[i][0], r = ints[i][1];
            if (list.size() == 0 || list.get(list.size() - 1)[1] < l){
                list.add(new int[]{l,r});
            }else {
                list.get(list.size() - 1)[1] = Math.max(r, list.get(list.size() - 1)[1]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }


    public static int[][] insert1(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int l = newInterval[0], r = newInterval[1];
        boolean insert = false;
        for (int[] interval : intervals) {
            int s = interval[0], e = interval[1];
            if (r < s) {
                if (!insert) {
                    ans.add(new int[]{l, r});
                    insert = true;
                }
                ans.add(interval);
            } else if (e < l) {
                ans.add(interval);
            } else {
                l = Math.min(l, s);
                r = Math.max(r, e);
            }
        }
        if (!insert) {
            ans.add(new int[]{l, r});
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4,8};
//        PrintUtil.printMatrix1(insert(intervals, newInterval));
        PrintUtil.printMatrix1(insert1(intervals, newInterval));
    }


}
