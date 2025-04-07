package com.catxu.leetcode.question72;

/**
 * 72. Edit Distance
 */
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        int i, j;
        // 删除
        for (i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        // 插入
        for (j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        // word1 前 i - 1 个字符转换成 word2 前 j - 1 个字符最少 cost
        for (i = 1; i <= m; i++) {
            char c1 = word1.charAt(i - 1);
            for (j = 1; j <= n; j++) {
                char c2 = word2.charAt(j - 1);
                if (c1 != c2) {
                    int deleteCost = dp[i - 1][j] + 1;
                    int insertCost = dp[i][j - 1] + 1;
                    int replaceCost = dp[i - 1][j - 1] + 1;
                    dp[i][j] = Math.min(deleteCost, Math.min(insertCost, replaceCost));
                } else {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minDistance("horse", "ros"));
        System.out.println(new Solution().minDistance("intention", "execution"));
        System.out.println(new Solution().minDistance("aaa", ""));
    }
}
