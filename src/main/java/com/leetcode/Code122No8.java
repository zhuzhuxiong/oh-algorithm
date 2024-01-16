package com.leetcode;

/**
 * 【数组】给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 *  在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 *  返回 你能获得的 最大 利润 。
 * @author zz
 */
public class Code122No8 {

    /**
     * 【动态规划】
     * dp[i][0] i日未持有股票 = dp[i-1][0] / dp[i-1][1]+prices[i]
     * dp[i][1] i日持有股票 = dp[i-1][1] / dp[i-1][0]-prices[i]
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[prices.length-1][0];
    }

    /***
     * 【贪心】
     * @param prices
     * @return
     */
    public static int maxProfit1(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit = profit + Math.max(0, prices[i] - prices[i-1]);
        }
        return profit;
    }


    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit1(prices));
        System.out.println(practice(prices));
    }

    public static int practice(int[] prices) {
        return 0;
    }
}
