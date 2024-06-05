package com.labula.array.intervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 区间-射箭
 * @author zz
 */
public class No5Code452 {

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        // 按 end 升序排序
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        // 至少有一个区间不相交
        int count = 1;
        // 排序后，第一个区间就是 x
        int x_end = points[0][1];
        for (int[] interval : points) {
            int start = interval[0];
            // 把 >= 改成 > 就行了
            if (start > x_end) {
                count++;
                x_end = interval[1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
       int[][] points = {{10,16},{2,8},{1,6},{7,12}};
       int[][] points1 = {{-2147483646,-2147483645},{2147483646,2147483647}};
        No5Code452 code452 = new No5Code452();
        System.out.println(code452.findMinArrowShots(points1));
        System.out.println(code452.practice(points1));
    }

    public int practice(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        Arrays.sort(points, (a, b) -> a[1] < b[1] ? -1 :1);

        int count = 1;
        long end = points[0][1];
        for (int[] point : points) {
            if (end <  point[0]) {
                count++;
                end = point[1];
            }

        }
        return count;
    }
}
