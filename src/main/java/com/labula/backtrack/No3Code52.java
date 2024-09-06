package com.labula.backtrack;

import java.util.Arrays;

/**
 * N Queen 二
 * @author
 */
public class No3Code52 {

    private int res = 0;
    public int totalNQueens(int n) {
        String[][] board = new String[n][n];
        for (String[] row : board) {
            Arrays.fill(row, ".");
        }
        backtrack(board, 0);
        return res;
    }

    private void backtrack(String[][] board, int row) {
        if (row == board.length) {
            res++;
            return;
        }

        for (int col = 0; col < board[row].length; col++) {
            if (!valid(board, row, col)) {
                continue;
            }

            board[row][col] = "Q";

            backtrack(board, row + 1);

            board[row][col] = ".";
        }
    }

    private boolean valid(String[][] board, int row, int col) {
        int n = board.length;
        for (int i = 0; i <= row; i++) {
            if ("Q".equals(board[i][col])) {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n ; i--, j++) {
            if ("Q".equals(board[i][j])) {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0 ; i--, j--) {
            if ("Q".equals(board[i][j])) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        No3Code52 code52 = new No3Code52();
        System.out.println(code52.totalNQueens(4));
        System.out.println(code52.practice(4));
    }

    int result = 0;
    public int practice(int n) {
        String[][] board = new String[n][n];
        for (String[] row : board) {
            Arrays.fill(row,".");
        }
        bk(board, 0);
        return result;
    }

    private void bk(String[][] board, int row) {
        if (row == board.length) {
            result++;
            return;
        }

        for (int col = 0; col < board[row].length; col++) {
            if (!valid(board, row, col)) {
                continue;
            }

            board[row][col] = "Q";

            bk(board, row + 1);

            board[row][col] = ".";
         }
    }

}
