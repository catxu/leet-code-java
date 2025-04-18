package com.catxu.leetcode.question678;

/**
 * 678. Valid Parenthesis String
 */
class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        // 定义dp[i][j]为考虑前i个字符（字符下标从1开始），能否与j个右括号形成合法括号序列
        boolean[][] dp = new boolean[n + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            char c = s.charAt(i - 1);
            for (int j = 0; j <= i; j++) {
                if (c == '(') {
                    if (j > 0) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else if (c == ')') {
                    if (j + 1 <= i) {
                        dp[i][j] = dp[i - 1][j + 1];
                    }
                } else { // *
                    dp[i][j] = dp[i - 1][j];
                    if (j + 1 <= i) dp[i][j] |= dp[i - 1][j + 1];
                    if (j > 0) dp[i][j] |= dp[i - 1][j - 1];
                }
            }
        }
        return dp[n][0];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().checkValidString("(*))"));
    }

}
