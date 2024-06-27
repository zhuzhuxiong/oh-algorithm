package com.labula.array.rotate;

import com.util.PrintUtil;

/**
 * 旋转图像
 *
 * @author zz
 */
public class No1Code48 {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //沿对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 每一个 单行翻转
        for (int[] row : matrix) {
            reverse(row);
        }
    }

    void reverse(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (j > i) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }


    public static void main(String[] args) {
        //输出：[[7,4,1],[8,5,2],[9,6,3]]
        int[][] matrix = {{1, 2, 3},{4, 5, 6},{7, 8, 9}};
        No1Code48 code48 = new No1Code48();
//        code48.rotate(matrix);
        code48.practice(matrix);
        PrintUtil.printMatrix1(matrix);
    }

    public void practice(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int[] row : matrix) {
            reversePractice(row);
        }
    }

    private void reversePractice(int[] row) {
        int i = 0, j = row.length - 1;
        while (i < j) {
            int tmp = row[i];
            row[i] = row[j];
            row[j] = tmp;
            i++;
            j--;
        }
    }

}
