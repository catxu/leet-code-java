package com.catxu.leetcode.question63;

/**
 * 63. Unique Paths II
 */
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        // 判断初始值是否有障碍
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0 || j == 0) {
                    dp[i][j] = i - 1 >= 0 ? dp[i - 1][j] : dp[i][j - 1];
                    continue;
                }
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniquePathsWithObstacles(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        }));
        System.out.println(solution.uniquePathsWithObstacles(new int[][]{
                {0, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 0, 0}
        }));
        System.out.println(solution.uniquePathsWithObstacles(new int[][]{
                {0, 0, 0},
                {0, 1, 0}
        }));
        System.out.println(solution.uniquePathsWithObstacles(new int[][]{
                {0, 0},
                {0, 1}
        }));
        System.out.println(solution.uniquePathsWithObstacles(new int[][]{
                {0, 0},
                {1, 0}
        }));
        System.out.println(solution.uniquePathsWithObstacles(new int[][]{
                {1, 0}
        }));
    }
}
