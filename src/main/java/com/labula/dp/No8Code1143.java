package com.labula.dp;

import java.util.Arrays;

/**
 * 最长公共子序列 LCS
 * @author zz
 */
public class No8Code1143 {

    int[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        memo = new int[m][n];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dp(text1, 0, text2, 0);
    }

    private int dp(String s1, int i, String s2, int j) {
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = 1 + dp(s1, i + 1, s2, j + 1);
        }else {
            memo[i][j] = Math.max(dp(s1, i + 1, s2, j), dp(s1, i, s2, j + 1));
        }
        return memo[i][j];
    }

    public int lcsDpTable(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        //dp[i][j] 为 t1[0,i-1] t2[0,j-1]的lcs长度
        //base case dp[0][j] = dp[i][0] = 0
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
//        输入：text1 = "abcde", text2 = "ace"
//        输出：3
//        解释：最长公共子序列是 "ace" ，它的长度为 3 。
        String text1 = "abcde", text2 = "ace";
        No8Code1143 code1143 = new No8Code1143();
        System.out.println(code1143.longestCommonSubsequence(text1, text2));
        System.out.println(code1143.lcsDpTable(text1, text2));
    }
}
