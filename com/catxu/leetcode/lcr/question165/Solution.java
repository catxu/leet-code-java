package com.catxu.leetcode.lcr.question165;

/**
 * LCR 165. 解密数字
 */
class Solution {
    public int crackNumber(int ciphertext) {
        String text = ciphertext + "";
        char[] s = text.toCharArray();
        int n = text.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int j, i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            if (i > 1 && (j = (s[i - 2] - '0') * 10 + (s[i - 1] - '0')) > 9 && j < 26) {
                // dp[i] 表示前 i - 1 个字符共有 x 种解密方式
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {
        System.out.println(new Solution().crackNumber(216612));
    }
}