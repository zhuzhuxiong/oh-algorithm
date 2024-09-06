package com.labula.backtrack;

import com.util.PrintUtil;

/**
 * 解数独
 *
 * @author zz
 */
public class No10Code37 {

    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    private boolean backtrack(char[][] board, int row, int col) {
        //board 9 * 9
        int m = 9, n = 9;
        //穷举换行，继续下一行
        if (col == n) {
            // return
            return backtrack(board, row + 1, 0);
        }
        //得到一个可行解
        if (row == m) {
            return true;
        }
        //已经预填了数字，跳过
        if ('.' != board[row][col]) {
            // return
            return backtrack(board, row, col + 1);
        }

        for (char ch = '1'; ch <= '9'; ch++) {
            //判断数字是否合法，false跳过
            if (!isValid(board, row, col, ch)) {
                continue;
            }
            board[row][col] = ch;

            //解可行，结束
            if (backtrack(board, row, col + 1)) {
                return true;
            }

            board[row][col] = '.';
        }
        //没找到答案，此路不通
        return false;
    }

    private boolean isValid(char[][] board, int r, int c, char ch) {
        for (int i = 0; i < 9; i++) {
            //判断行内冲突
            if (board[r][i] == ch) {
                return false;
            }
            //判断列内重复
            if (board[i][c] == ch) {
                return false;
            }
            /** 判断 3 * 3 范围内重复否*/
            if (board[(r / 3) * 3 + i / 3][(c / 3) * 3 + i % 3] == ch) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        输入：board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
//        输出：[["5","3","4","6","7","8","9","1","2"],
//              ["6","7","2","1","9","5","3","4","8"],
//              ["1","9","8","3","4","2","5","6","7"],
//              ["8","5","9","7","6","1","4","2","3"],
//              ["4","2","6","8","5","3","7","9","1"],
//              ["7","1","3","9","2","4","8","5","6"],
//              ["9","6","1","5","3","7","2","8","4"],
//              ["2","8","7","4","1","9","6","3","5"],
//              ["3","4","5","2","8","6","1","7","9"]]
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        No10Code37 code37 = new No10Code37();
//        code37.solveSudoku(board);
        code37.practice(board);
        PrintUtil.printMatrix(board);
    }

    /***************************************************************************************************************/
    public void practice(char[][] board) {
//        bk(board, 0, 0);
    }

}
