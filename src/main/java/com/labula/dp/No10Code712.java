package com.labula.dp;

import java.util.Arrays;

/**
 * 两个字符串的最小ASCII删除和
 * @author zz
 */
public class No10Code712 {

    int[][] memo;
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(s1, 0, s2, 0);
    }

    private int dp(String s1, int i, String s2, int j) {
        int res = 0;
        if (i == s1.length()) {
            //如果s1到头了，那么s2剩下的都得删除
            for (; j < s2.length(); j++) {
                res = res + s2.charAt(j);
            }
            return res;
        }
        if (j == s2.length()) {
            for (; i < s1.length(); i++) {
                res = res + s1.charAt(i);
            }
            return res;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = dp(s1, i + 1, s2, j + 1);
        }else {
            //s1[i]和s2[j]至少有一个不在lcs中，删一个
            memo[i][j] = Math.min(s1.charAt(i) + dp(s1, i + 1, s2, j),
                    s2.charAt(j) + dp(s1, i, s2, j + 1));
        }
        return memo[i][j];
    }

    public static void main(String[] args) {
//        输入: s1 = "sea", s2 = "eat"
//        输出: 231
        String s1 = "sea", s2 = "eat";
        No10Code712 code712 = new No10Code712();
        System.out.println(code712.minimumDeleteSum(s1, s2));
        System.out.println(code712.practice(s1, s2));
    }

    int[][] memos;
    public int practice(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        memos = new int[m][n];
        for (int[] ints : memos) {
            Arrays.fill(ints, -1);
        }
        return dpp(s1, 0, s2, 0);
    }

    private int dpp(String s1, int i, String s2, int j) {
        int res = 0;
        if (i == s1.length()) {
            for (; j < s2.length(); j++) {
                res += s2.charAt(j);
            }
            return res;
        }
        if (j == s2.length()) {
            for (; i < s1.length(); i++) {
                res += s1.charAt(i);
            }
            return res;
        }

        if (memos[i][j] != -1) {
            return memos[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            memos[i][j] = dpp(s1, i + 1, s2, j + 1);
        }else {
            memos[i][j] = Math.min(dpp(s1, i + 1, s2, j) + s1.charAt(i), dpp(s1, i, s2, j + 1) + s2.charAt(j));
        }

        return memos[i][j];
    }
}
