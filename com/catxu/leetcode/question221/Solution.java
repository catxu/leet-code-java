package com.catxu.leetcode.question221;

/**
 * 221. Maximal Square
 *
 * <pre>
 * #	#	#	#	#	.	0	#	#	#	#	.	#	#	#	#	0
 * #	#	#	#	#	.	#	#	#	#	#	.	#	#	#	#	0
 * #	#	#	#	#	.	#	#	#	#	#	.	#	#	#	#	#
 * #	#	#	4	4	.	#	#	#	3	4	.	#	#	#	4	2
 * 0	0	#	2	？	.	#	#	#	4	？	.	#	#	#	4	？
 * </pre>
 */
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        // dp[i][j] 表示以 matrix[i-1][j-1] 为右下角的、且只包含 '1' 的最大正方形的边长
        int[][] dp = new int[m + 1][n + 1];
        int i, j, ans = 0;

        for (i = 1; i <= m; i++) {
            for (j = 1; j <= n; j++) {
                char c = matrix[i - 1][j - 1];
                if (c == '1') {
                    /* 这里逻辑可以合并
                    if (dp[i - 1][j] == dp[i - 1][j - 1] && dp[i - 1][j] == dp[i][j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    } */
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return ans * ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximalSquare(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'},
        }));
        System.out.println(new Solution().maximalSquare(new char[][]{
                {'1', '0'},
                {'1', '0'},
                {'1', '1'},
                {'1', '0'},
        }));
    }
}
