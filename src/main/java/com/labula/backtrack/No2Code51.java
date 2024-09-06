package com.labula.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * N Queen
 *
 * @author zz
 */
public class No2Code51 {

    private List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        /** 初始化棋盘，"."：空  "Q"：皇后 */
        String[][] board = new String[n][n];
        for (String[] item : board) {
            Arrays.fill(item, ".");
        }
        res = new ArrayList<>();
        backtrack(board, 0);
        return res;
    }

    /***
     * 路径：board 中小于row 的行已经防止了皇后
     * 选择列表：第row行 所有列都是放置选择
     * 结束条件：row超过board最后一行
     * @param board
     * @param row
     */
    private void backtrack(String[][] board, int row) {
        /** 结束条件 */
        if (row == board.length) {
            ArrayList<String> tmp = new ArrayList<>();
            for (String[] strings : board) {
                tmp.add(String.join("", strings));
            }
            res.add(tmp);
            return;
        }

        for (int col = 0; col < board[row].length; col++) {
            /** 过滤不合条件 */
            if (!isValid(board, row, col)) {
                continue;
            }

            /** 做选择 */
            board[row][col] = "Q";
            /** 回溯 */
            backtrack(board, row + 1);
            /** 撤销选择*/
            board[row][col] = ".";
        }
    }

    /**
     * 判断board[row][col]是否可以放皇后
     *
     * @param board
     * @param row
     * @param col
     * @return
     */
    private boolean isValid(String[][] board, int row, int col) {
        int n = board.length;
        /** 列冲突检查 */
        for (int i = 0; i <= row; i++) {
            if ("Q".equals(board[i][col])) {
                return false;
            }
        }

        /** 右上方 */
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if ("Q".equals(board[i][j])) {
                return false;
            }
        }

        /** 左上方 */
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if ("Q".equals(board[i][j])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        No2Code51 code51 = new No2Code51();
        System.out.println(code51.solveNQueens(4));
        System.out.println(code51.practice(4));
    }


    List<List<String>> result = new ArrayList<>();

    public List<List<String>> practice(int n) {
        String[][] board = new String[n][n];
        for (String[] row : board) {
            Arrays.fill(row, ".");
        }
        bk(board, 0);
        return result;
    }

    private void bk(String[][] board, int row) {
        if (row == board.length) {
            LinkedList<String> temp = new LinkedList<>();
            for (String[] strings : board) {
                temp.add(String.join("", strings));
            }
            result.add(temp);
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


}
