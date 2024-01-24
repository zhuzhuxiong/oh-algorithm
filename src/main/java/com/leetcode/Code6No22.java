package com.leetcode;

/**
 * Z字型变换
 * @author zz
 */
public class Code6No22 {

    public static String convert(String s, int numRows) {
        int n = s.length(), r = numRows;
        if (r == 1 || r >= n) {
            return s;
        }
        //周期 丨/  丨:r,/:r-2
        int t = 2 * r - 2;
        //列数：基本公式（n/t）* (r-1)  r-1为每个周期的列数；
        int c = (n + t -1) / t * (r - 1);
        char[][] mat = new char[r][c];
        //矩阵赋值，从左上角（x=0,y=0）开始
        for (int i = 0, x = 0, y = 0; i < n; i++) {
            mat[x][y] = s.charAt(i);
            // 索引小于r-1在竖线上，x++向下，否则 向右上
            if (i % t < r - 1){
                x++;
            }else {
                x--;
                y++;
            }
        }
        //取出所以不为0的，即为答案
        StringBuilder builder = new StringBuilder();
        for (char[] chars : mat) {
            for (char aChar : chars) {
                if (aChar != 0) {
                    builder.append(aChar);
                }
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        System.out.println(convert(s,3));

        System.out.println(convert(s,4));
        System.out.println(convert("A",4));

        System.out.println(practice(s,4));
        System.out.println(practice("A",4));
    }

    public static String practice(String s, int numRows) {
        int n = s.length(), r = numRows;
        if (n <= r || r == 1) {
            return s;
        }
        int t = r + r - 2;
        int c = (n + t -1) / t * (r - 1);
        char[][] chars = new char[r][c];
        for (int i = 0, x = 0, y = 0; i < n; i++) {
            chars[x][y] = s.charAt(i);
            if (i % t < r - 1){
                x++;
            }else {
                y++;
                x--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char[] aChar : chars) {
            for (char cc : aChar) {
                if (cc != 0){
                    sb.append(cc);
                }
            }
        }
        return sb.toString();
    }
}
