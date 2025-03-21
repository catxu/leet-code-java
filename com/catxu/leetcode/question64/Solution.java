package com.catxu.leetcode.question64;

/**
 * 64. Minimum Path Sum
 * <p>
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.
 * <p>
 * Example 1:
 * <p>
 * <img src="./minpath.png" />
 * <p>
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * <p>
 * Output: 7
 * <p>
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 * <p>
 * Example 2:
 * <p>
 * Input: grid = [[1,2,3],[4,5,6]]
 * <p>
 * Output: 12
 * <p>
 * Constraints:
 * <p>
 * m == grid.length
 * <p>
 * n == grid[i].length
 * <p>
 * 1 <= m, n <= 200
 * <p>
 * 0 <= grid[i][j] <= 200
 */
class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i - 1 < 0 && j - 1 < 0) {
                    continue;
                }
                // dp[i][j]最优解 = min(dp[i-1][j] 向右移, dp[i][j-1] 向下移) + grid[i][j]
                dp[i][j] = Math.min(i - 1 < 0 ? Integer.MAX_VALUE : dp[i - 1][j],
                        j - 1 < 0 ? Integer.MAX_VALUE : dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

//    public int minPathSum(int[][] grid) {
//        int[][] memo = new int[grid.length][grid[0].length];
//        for (int[] row : memo) {
//            Arrays.fill(row, -1);
//        }
//        return dfs(grid, memo, 0, 0);
//    }
//
//    private int dfs(int[][] grid, int[][] memo, int r, int c) {
//        int rows = grid.length;
//        int cols = grid[0].length;
//        if (r == rows - 1 && c == cols - 1) {
//            return grid[r][c];
//        }
//        if (memo[r][c] != -1) {
//            return memo[r][c];
//        }
//        int right = c + 1 < cols ? dfs(grid, memo, r, c + 1) : Integer.MAX_VALUE;
//        int down = r + 1 < rows ? dfs(grid, memo, r + 1, c) : Integer.MAX_VALUE;
//        memo[r][c] = grid[r][c] + Math.min(right, down);
//        return memo[r][c];
//    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minPathSum(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        }));
        System.out.println(s.minPathSum(new int[][]{
                {1, 2, 3},
                {4, 5, 6}
        }));
        System.out.println(s.minPathSum(new int[][]{
                {1},
                {4}
        }));

    }
}