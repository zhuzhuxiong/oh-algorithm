package com.labula.dp;

import java.util.Arrays;

/**
 * 子序列--编辑距离
 *
 * @author zz
 */
public class No6Code72 {

    /**
     * 递归+备忘录
     */
    int[][] memo;

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        memo = new int[m][n];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        //从 后向前 遍历
        return dp(word1, m - 1, word2, n - 1);
    }

    /**
     * dp:返回word1[0-i] 到 word2[0-j]的最小编辑距离
     */
    private int dp(String word1, int i, String word2, int j) {
        //base case word1结束，编辑距离即word2剩下的长度
        if (i == -1) {
            return j + 1;
        }
        if (j == -1) {
            return i + 1;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        //字符相同，跳过
        if (word1.charAt(i) == word2.charAt(j)) {
            memo[i][j] = dp(word1, i - 1, word2, j - 1);
        } else {
            memo[i][j] = min(
                    //新增：w1新增一个字符，w2向前移动一个位置
                    dp(word1, i, word2, j - 1) + 1,
                    //删除：w1移动一个，w2不动
                    dp(word1, i - 1, word2, j) + 1,
                    //替换：都移动至下一个
                    dp(word1, i - 1, word2, j - 1) + 1
            );
        }
        return memo[i][j];
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }


    /**
     * dp table
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance1(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min(
                            dp[i - 1][j] + 1,
                            dp[i][j - 1] + 1,
                            dp[i - 1][j - 1] + 1
                    );
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String word1 = "", word2 = "a";
        No6Code72 code72 = new No6Code72();
        System.out.println(code72.minDistance(word1, word2));
        System.out.println(code72.minDistance1(word1, word2));
        System.out.println(code72.practice(word1, word2));
    }

    int[][] memos;

    public int practice(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[m][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][n] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    dp[i][j] = min(dp[i-1][j] + 1,dp[i][j-1] + 1, dp[i-1][j-1] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
