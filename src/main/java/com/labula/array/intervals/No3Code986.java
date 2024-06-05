package com.labula.array.intervals;

import com.util.PrintUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zz
 */
public class No3Code986 {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {
            int a1 = firstList[i][0], a2 = firstList[i][1];
            int b1 = secondList[j][0], b2 = secondList[j][1];

            if (a2 >= b1 && a1 <= b2) {
                res.add(new int[]{Math.max(a1, b1), Math.min(a2, b2)});
            }
            if (b2 > a2) {
                i++;
            } else {
                j++;
            }
        }
        return res.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
//        输出：[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
        int[][] firstList = {{0, 2}, {5, 10}, {13, 23}, {24, 25}}, secondList = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        No3Code986 code986 = new No3Code986();
        PrintUtil.printMatrix1(code986.intervalIntersection(firstList, secondList));
        PrintUtil.printMatrix1(code986.practice(firstList, secondList));

    }

    public int[][] practice(int[][] firstList, int[][] secondList) {
        ArrayList<int[]> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {
            int a1 = firstList[i][0], a2 = firstList[i][1];
            int b1 = secondList[j][0], b2 = secondList[j][1];

            if (a1 <= b2 && a2 >= b1) {
                res.add(new int[]{Math.max(a1, b1), Math.min(a2, b2)});
            }

            if (a2 > b2) {
                j++;
            }else {
                i++;
            }
        }
        return res.toArray(new int[0][0]);
    }
}
