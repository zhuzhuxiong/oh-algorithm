package com.labula.dp;

import java.util.Arrays;

/**
 * 斐波那契数列 dynamic programming
 *
 * @author zz
 */
public class No1Code509 {

    /**
     # 自顶向下递归的动态规划
     def dp(状态1, 状态2, ...):
     for 选择 in 所有可能的选择:
     # 此时的状态已经因为做了选择而改变
     result = 求最值(result, dp(状态1, 状态2, ...))
     return result

     # 自底向上迭代的动态规划
     # 初始化 base case
     dp[0][0][...] = base case
     # 进行状态转移
     for 状态1 in 状态1的所有取值：
     for 状态2 in 状态2的所有取值：
     for ...
     dp[状态1][状态2][...] = 求最值(选择1，选择2...)
     */

    /**
     * 1、普通
     *
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
     * 2 带备忘录(数组 或 哈希表)
     *      （自顶向下的方式 fib(20) --> fib(1)）
     * @param n
     * @return
     */
    public int fibMemo(int n) {
        //memo[i] 为fib(i)的值
        int[] memo = new int[n + 1];
        return dp(n, memo);
    }

    private int dp(int n, int[] memo) {
        if (0 == n || 1 == n) {
            return n;
        }
        //memo数组初始化为0
        if (memo[n] != 0) {
            return memo[n];
        }

        memo[n] = dp(n - 1, memo) + dp(n - 2, memo);
        return memo[n];
    }


    /**
     * 3 自底向上(数组的迭代解法)
     *
     * @param n
     * @return
     */
    public int fibBottomToTop(int n) {
        if (n == 0) {
            return 0;
        }
        //dp表
        int[] dp = new int[n + 1];
        //base case
        dp[0] = 0;
        dp[1] = 1;

        //状态转移方程
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    /**
     * 4 继续优化（O(1)）
     *
     * @param n
     * @return
     */
    public int fib3(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        //记录 i-1 i-2；
        int dp1 = 1, dp2 = 0;
        for (int i = 2; i <= n; i++) {
            int dp = dp1 + dp2;
            dp2 = dp1;
            dp1 = dp;
        }
        return dp1;
    }


    public static void main(String[] args) {
        No1Code509 code509 = new No1Code509();
        int n = 9;
        Long start = System.currentTimeMillis();
        System.out.println(code509.fib(n));
        System.out.println("fib1:" + (System.currentTimeMillis() - start));
        System.out.println(code509.fibMemo(n));
        System.out.println("fib2:" + (System.currentTimeMillis() - start));
        System.out.println(code509.fibBottomToTop(n));
        System.out.println("fib3:" + (System.currentTimeMillis() - start));
        System.out.println(code509.fib3(n));
        System.out.println("fib4:" + (System.currentTimeMillis() - start));
        System.out.println(code509.practice(n));
        System.out.println("practice:" + (System.currentTimeMillis() - start));
    }

    public int practice(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int dp1 = 1, dp0 = 0;
        for (int i = 2; i <= n; i++) {
            int dp = dp1 + dp0;
            dp0 = dp1;
            dp1 = dp;
        }
        return dp1;
    }


}
