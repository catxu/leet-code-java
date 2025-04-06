package com.catxu.leetcode.question123;

/**
 * 123. Best Time to Buy and Sell Stock III
 */
class Solution {
    public int maxProfit(int[] prices) {
        // [ stage 1 ][ stage 2 ][ stage 3 ][ stage 4 ][ stage 5 ]
        // 1: 第一次买之前
        // 2: 持有股票
        // 3: 第一次卖出股票 到 第二次买入前
        // 4: 持有股票
        // 5: 第二次卖出后
        int n = prices.length, stage = 5;
        // dp[i][j] 第 i 天结束后，处在阶段 j，最大获利
        int[][] dp = new int[n + 1][stage + 1];
        // init
        for (int j = 2; j <= stage; j++) {
            dp[0][j] = Integer.MIN_VALUE; // 第 0 天不可能处于这些阶段
        }
        dp[0][1] = 0; // 未买卖股票，最大利润为 0
        for (int i = 1; i <= n; i++) {
            // 1, 3, 5 stage
            for (int j = 1; j <= 5; j += 2) {
                dp[i][j] = dp[i - 1][j];
                if (j > 1 && i > 1 && dp[i - 1][j - 1] != Integer.MIN_VALUE) {
                    // 2->3 / 4->5 当天卖出或者保持 stage j
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + (prices[i - 1] - prices[i - 2]));
                }
            }
            // 2, 4 stage
            for (int j = 2; j <= 4; j += 2) {
                dp[i][j] = dp[i - 1][j - 1];
                if (i > 1 && dp[i - 1][j] != Integer.MIN_VALUE) {
                    // 当天买入或者 保持持有
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + (prices[i - 1] - prices[i - 2]));
                }
            }
        }
        return Math.max(dp[n][1], Math.max(dp[n][3], dp[n][5]));
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(s.maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(s.maxProfit(new int[]{1, 2}));
        System.out.println(s.maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(s.maxProfit(new int[]{3, 2, 6, 5, 0, 3}));
    }
}
