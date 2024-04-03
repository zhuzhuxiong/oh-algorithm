package com.labula.dynamicProgramming;

/**
 * @author zz
 */
public class Code509No1 {

    /**
     * 1、普通
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }


    /**
     * 2 带备忘录
     * @param n
     * @return
     */
    public int fib1(int n) {
        int[] memo = new int[n + 1];
        return dp(n, memo);
    }

    private int dp(int n, int[] memo) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = dp(n - 1, memo) + dp(n - 2, memo);
        return memo[n];
    }


    /**
     * 3 自底向上
     * @param n
     * @return
     */
    public int fib2(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    /**
     * 4
     * @param n
     * @return
     */
    public int fib3(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int dp1 = 1, dp2 = 0;
        for (int i = 2; i <= n; i++) {
            //dp = dp[i-1] + dp[i-2]
            int dp = dp1 + dp2;
            dp2 = dp1;
            dp1 = dp;
        }
        return dp1;
    }



    public static void main(String[] args) {

    }
}
