package com.labula.array.binary;

/**
 * 搜索二维矩阵
 *
 * @author zz
 */
public class No8Code74 {

    /**
     * 一二维坐标映射
     * 已知行列 m, n ; 二维数组坐标(i, j); 一维下标 index
     * index = i * n + j;
     * i = index / n, j = index % j;
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (get(matrix, mid) == target) {
                return true;
            }else if (get(matrix, mid) < target) {
                left = mid + 1;
            }else if (get(matrix, mid) > target) {
                right = mid - 1;
            }
        }
        return false;
    }

    private int get(int[][] matrix, int index) {
        int n = matrix[0].length;
        int i = index / n, j = index % n;
        return matrix[i][j];
    }

    public static void main(String[] args) {
//        输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//        输出：true
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        No8Code74 code74 = new No8Code74();
        System.out.println(code74.searchMatrix(matrix, 3));
    }
}
