package com.catxu.leetcode.question279;

/**
 * 279. Perfect Squares
 */
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1]; // 默认初始化值都为 0
        for (int i = 1; i <= n; i++) {
            dp[i] = i; // 最坏的情况就是每次 + 1
            for (int j = 1, t; (t = i - j * j) >= 0; j++) {
                // dp[8] = dp[7] + 1
                // dp[8] = dp[4] + 1
                dp[i] = Math.min(dp[i], dp[t] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numSquares(3));
        System.out.println(new Solution().numSquares(10000));
    }
}