package com.leetcode;

import com.util.PrintUtil;

/**
 * @author zz
 */
public class Code289No38 {

    /**
     * 额外空间
     *
     * @param board
     */
    public static void gameOfLife(Integer[][] board) {
        int[] neighbors = {0, 1, -1};

        int rows = board.length;
        int cols = board[0].length;

        int[][] copy = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                copy[i][j] = board[i][j];
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                int liveNeighbor = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
                            int r = row + neighbors[i];
                            int c = col + neighbors[j];

                            if (r < rows && r >= 0 && c < cols && c >= 0 && copy[r][c] == 1) {
                                liveNeighbor += 1;
                            }
                        }
                    }
                }
                if (copy[row][col] == 1 && (liveNeighbor < 2 || liveNeighbor > 3)) {
                    board[row][col] = 0;
                }
                if (copy[row][col] == 0 && liveNeighbor == 3) {
                    board[row][col] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        gameOfLife(board);
        PrintUtil.printMatrix1(board);
    }
}
