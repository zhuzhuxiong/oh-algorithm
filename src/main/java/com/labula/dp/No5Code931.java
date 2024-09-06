package com.labula.dp;

import java.util.Arrays;

/**
 * 下降路径最小和
 *
 * @author zz
 */
public class No5Code931 {

    int[][] memo;

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int res = Integer.MAX_VALUE;

        memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], 66666);
        }

        for (int i = 0; i < n; i++) {
            res = Math.min(res, dp(matrix, n - 1, i));
        }
        return res;
    }

    private int dp(int[][] matrix, int i, int j) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            return 99999;
        }
        if (i == 0) {
            return matrix[0][j];
        }

        if (memo[i][j] != 66666) {
            return memo[i][j];
        }

        memo[i][j] = matrix[i][j] + min(dp(matrix, i - 1, j), dp(matrix, i - 1, j - 1), dp(matrix, i - 1, j + 1));

        return memo[i][j];
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static void main(String[] args) {
        int[][] matrix = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        No5Code931 code931 = new No5Code931();
        System.out.println(code931.minFallingPathSum(matrix));
        System.out.println(code931.practice(matrix));
    }

    int[][] memos;
    public int practice(int[][] matrix) {
        int m = matrix.length;
        memos = new int[m][m];
        for (int i = 0; i < memos.length; i++) {
            Arrays.fill(memos[i], 666666);
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            res = Math.min(res, dpp(matrix, m - 1 , i));
        }

        return res;
    }

    private int dpp(int[][] matrix, int i, int j) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            return 999999;
        }
        if (i == 0) {
            return matrix[0][j];
        }
        if (memos[i][j] != 666666) {
            return memos[i][j];
        }

        memos[i][j] = matrix[i][j] + min(dpp(matrix, i - 1, j - 1), dpp(matrix, i - 1, j), dpp(matrix, i - 1, j + 1));
        return memos[i][j];
    }
}
