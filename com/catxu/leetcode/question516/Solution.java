package com.catxu.leetcode.question516;

/**
 * 516. Longest Palindromic Subsequence
 */
class Solution {
    public int longestPalindromeSubseq(String s) {
        char[] S = s.toCharArray();
        int n = S.length;
        // dp[i][j] 字符串 [i, j] 中的最大回文子序列
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            char c1 = S[i];
            for (int j = i + 1; j < n; j++) {
                char c2 = S[j];
                if (c1 == c2) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
