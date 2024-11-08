package com.labula.dp;

/**
 * 最长回文子序列
 * @author zz
 */
public class No11Code516 {

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        //在子串 s[i..j] 中，最长回文子序列的长度为 dp[i][j]。
        //i,j 为字符串s的一头一尾
        int[][] dp = new int[n][n];

        //base case 根据定义 i == j时 为一个字符 dp[i][i] = 1;
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
//        输入：s = "bbbab"
//        输出：4
//        解释：一个可能的最长回文子序列为 "bbbb" 。
        String s = "bbbab";
        No11Code516 code516 = new No11Code516();
        System.out.println(code516.longestPalindromeSubseq(s));
        System.out.println(code516.practice(s));
    }

    public int practice(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int i = n - 1; i >=0 ; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }
}
