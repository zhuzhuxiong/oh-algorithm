package com.labula.array.rotate;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zz
 */
public class No2Code54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        LinkedList<Integer> res = new LinkedList<>();
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = n - 1;
        int upper = 0, bottom = m - 1;
        while (res.size() < m * n) {
            if (upper <= bottom) {
                for (int i = left; i <= right; i++) {
                    res.add(matrix[upper][i]);
                }
                upper++;
            }

            if (left <= right) {
                for (int i = upper; i <= bottom; i++) {
                    res.add(matrix[i][right]);
                }
                right--;
            }

            if (upper <= bottom) {
                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= upper; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        输出：[1,2,3,6,9,8,7,4,5]
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        No2Code54 code54 = new No2Code54();
        System.out.println(code54.spiralOrder(matrix));
    }
}
