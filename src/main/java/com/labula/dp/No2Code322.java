package com.labula.dp;

import java.util.Arrays;

/**
 * 零钱兑换
 * @author zz
 */
public class No2Code322 {

    /**
     * 自上向下
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        //base case
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            //子问题
            int sub = coinChange(coins, amount - coin);
            //不符合
            if (sub == -1) {
                continue;
            }
            //找最优
            res = Math.min(res,sub + 1);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    /**
     * 2-带备忘录
     * @param coins
     * @param amount
     * @return
     */
    int[] memo;
    public int coinChangeMemo(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, -666);
        return dp(coins, amount);
    }

    private int dp(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (memo[amount] != -666) {
            return memo[amount];
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int sub = dp(coins, amount - coin);
            if (sub == -1) {
                continue;
            }
            res = Math.min(res, sub + 1);
        }
        memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
        return memo[amount];
    }

    /**
     * 自下向上
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange1(int[] coins, int amount) {
        //dp table 凑出amount所需的硬币数
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        //base case
        dp[0] = 0;

        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(new No2Code322().coinChange(coins, amount));
        System.out.println(new No2Code322().coinChangeMemo(coins, amount));
        System.out.println(new No2Code322().coinChange1(coins, amount));
        System.out.println(new No2Code322().practice(coins, amount));
    }




    public int practice(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        for (int i = 1; i <dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
