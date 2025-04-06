package com.catxu.leetcode.question188;

/**
 * 188. Best Time to Buy and Sell Stock IV
 */
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int ans = 0;
        if (k > n / 2) {
            for (int i = 0; i < n - 1; i++) {
                if (prices[i + 1] > prices[i]) {
                    ans += prices[i + 1] - prices[i];
                }
            }
            return ans;
        }
        // 第一次买入前
        // 持有
        // 第二次买入前
        // 持有
        // ...
        // 第k-1次买入前
        // 持有
        // 第k次买入前
        // 持有
        // 第k次卖出后
        int[][] dp = new int[n + 1][2 * k + 2];
        for (int j = 2; j <= 2 * k + 1; j++) {
            dp[0][j] = Integer.MIN_VALUE;
        }
        dp[0][1] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 2 * k + 1; j += 2) {
                dp[i][j] = dp[i - 1][j];
                if (j > 1 && i > 1 && dp[i - 1][j - 1] != Integer.MIN_VALUE) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + prices[i - 1] - prices[i - 2]);
                }
            }
            for (int j = 2; j <= 2 * k; j += 2) {
                dp[i][j] = dp[i - 1][j - 1];
                if (i > 1 && dp[i - 1][j] != Integer.MIN_VALUE) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + prices[i - 1] - prices[i - 2]);
                }
            }
        }
        for (int j = 1; j <= 2 * k + 1; j += 2) {
            ans = Math.max(ans, dp[n][j]);
        }
        return ans;
    }
}