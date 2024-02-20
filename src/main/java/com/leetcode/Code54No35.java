package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zz
 */
public class Code54No35 {

    /**
     * 模拟
     *
     * @param matrix
     * @return
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }

        int rows = matrix.length, cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int total = rows * cols;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int row = 0, col = 0;
        int directionIndex = 0;

        for (int i = 0; i < total; i++) {
            list.add(matrix[row][col]);
            visited[row][col] = true;

            int nextRow = row + directions[directionIndex][0];
            int nextCol = col + directions[directionIndex][1];

            if (nextRow < 0 || nextRow >= rows
                    || nextCol < 0 || nextCol >= cols
                    || visited[nextRow][nextCol]) {
                directionIndex = (directionIndex + 1) % 4;
            }

            row += directions[directionIndex][0];
            col += directions[directionIndex][1];
        }
        return list;
    }

    /**
     * 一层一层向内
     *
     * @param matrix
     * @return
     */
    public static List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (null == matrix || 0 == matrix.length || 0 == matrix[0].length) {
            return res;
        }

        int rows = matrix.length, cols = matrix[0].length;
        int left = 0, right = cols - 1;
        int top = 0, bottom = rows - 1;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            for (int i = top + 1; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            if (left < right && top < bottom) {
                for (int i = right - 1; i > left; i--) {
                    res.add(matrix[bottom][i]);
                }
                for (int i = bottom; i > top; i--) {
                    res.add(matrix[i][left]);
                }
            }
            top++;
            bottom--;
            left++;
            right--;
        }
        return res;
    }


    public static void main(String[] args) {
//        输出：[1,2,3,6,9,8,7,4,5]
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiralOrder(matrix));
        System.out.println(spiralOrder1(matrix));

        System.out.println(practice(matrix));

    }

    public static List<Integer> practice(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (null == matrix || 0 == matrix.length || 0 == matrix[0].length) {
            return res;
        }

        int rows = matrix.length, cols = matrix[0].length;
        int total = rows * cols;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] visited = new boolean[rows][cols];

        int row = 0, col = 0;
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            res.add(matrix[row][col]);
            visited[row][col] = true;

            int nextRow = row + directions[directionIndex][0];
            int nextCol = col + directions[directionIndex][1];

            if (nextRow < 0 || nextRow >= rows
                    || nextCol < 0 || nextCol >= cols
                    || visited[nextRow][nextCol]) {
                directionIndex = (directionIndex + 1) % 4;
            }

            row += directions[directionIndex][0];
            col += directions[directionIndex][1];
        }
        return res;
    }
}
