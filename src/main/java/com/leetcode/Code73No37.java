package com.leetcode;

import com.util.PrintUtil;

/**
 * @author
 */
public class Code73No37 {

    /**
     * 原地
     *
     * @param matrix
     */
    public static void setZeroes(Integer[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean colFlag = false, rowFlag = false;

        //第一列有无0判断
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                colFlag = true;
                break;
            }
        }
        //第一行有无0判断
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                rowFlag = true;
                break;
            }
        }

        //除第一行外，将为0的值，同时赋给第一行，第一列
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        //根据首行首列为基准，设置0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        //处理首列中原本有0的情况，即设置首列为0
        if (colFlag) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        //处理首行中原本有0的情况，即设置首行为0
        if (rowFlag) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
    }

    public static void setZeroes1(Integer[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] rowFlag = new boolean[m];
        boolean[] colFlag = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rowFlag[i] = true;
                    colFlag[j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rowFlag[i] || colFlag[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        Integer[][] matrix1 = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(matrix);
        PrintUtil.printMatrix1(matrix);
        System.out.println("------------------");
        setZeroes(matrix1);
        PrintUtil.printMatrix1(matrix1);
        System.out.println("------------------");

        Integer[][] matrix2 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        Integer[][] matrix22 = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        practice(matrix2);
        PrintUtil.printMatrix1(matrix2);
        System.out.println("------------------");
        practice(matrix22);
        PrintUtil.printMatrix1(matrix22);
    }

    public static void practice(Integer[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean rowFlag = false, colFlag = false;

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                rowFlag = true;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                colFlag = true;
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (rowFlag) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

        if (colFlag) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }


    }
}
