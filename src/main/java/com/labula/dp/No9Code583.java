package com.labula.dp;

/**
 * 两个字符串删除操作
 * @author zz
 */
public class No9Code583 {

    public int minDistance(String word1, String word2) {
        int lcs = lcs(word1, word2);
        return word1.length() - lcs + (word2.length() - lcs);
    }

    private int lcs(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
//        输入: word1 = "sea", word2 = "eat"
//        输出: 2
//        解释: 第一步将 "sea" 变为 "ea" ，第二步将 "eat "变为 "ea"
        String word1 = "sea", word2 = "eat";
        No9Code583 code583 = new No9Code583();
        System.out.println(code583.minDistance(word1, word2));
    }
}
