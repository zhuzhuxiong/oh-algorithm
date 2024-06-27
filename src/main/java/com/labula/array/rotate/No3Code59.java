package com.labula.array.rotate;

import com.util.PrintUtil;

/**
 * @author zz
 */
public class No3Code59 {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int upper = 0, bottom = n - 1;
        int left = 0, right = n - 1;
        int num = 1;
        while (num <= n * n) {
            if (upper <= bottom) {
                for (int i = left; i <= right; i++) {
                    matrix[upper][i] = num++;
                }
                upper++;
            }

            if (left <= right) {
                for (int i = upper; i <= bottom; i++) {
                    matrix[i][right] = num++;
                }
                right--;
            }

            if (upper <= bottom) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = num++;
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= upper; i--) {
                    matrix[i][left] = num++;
                }
                left++;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        No3Code59 code59 = new No3Code59();
        PrintUtil.printMatrix1(code59.generateMatrix(3));
    }
}
