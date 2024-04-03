package com.labula.dynamicProgramming;

import java.util.Arrays;

/**
 * @author zz
 */
public class Code322No2 {

    public int coinChange(int[] coins, int amount) {
        return dp(coins,amount);
    }

    /**
     * 返回需要的coin数量
     * @param coins
     * @param amount
     * @return
     */
    private int dp(int[] coins, int amount) {
        //base case
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            //子问题解
            int sub = dp(coins, amount - coin);
            if (sub == -1) {
                continue;
            }
            //取最优解（子问题解+1 当前问题也需要一个coin）
            res = Math.min(res, sub + 1);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    /**
     * 带备忘录版
     * @param coins
     * @param amount
     * @return
     */
    int[] memo;
    int coinChange1(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, -666);
        return dp1(coins, amount);
    }

    private int dp1(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0){
            return -1;
        }

        if (memo[amount] != -666) {
            return memo[amount];
        }

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int sub = dp1(coins, amount - coin);
            if (sub < 0) {
                continue;
            }
            res = Math.min(res, sub + 1);
        }
        memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
        return memo[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(new Code322No2().coinChange(coins, amount));
    }
}
