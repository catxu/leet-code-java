package com.catxu.leetcode.weekly432.q2;

/**
 * Q2. Maximum Amount of Money Robot Can Earn
 * <p>
 * You are given an m x n grid. A robot starts at the top-left corner of the grid (0, 0) and wants to reach the bottom-right corner (m - 1, n - 1). The robot can move either right or down at any point in time.
 * <p>
 * The grid contains a value coins[i][j] in each cell:
 * <p>
 * If coins[i][j] >= 0, the robot gains that many coins.
 * <p>
 * If coins[i][j] < 0, the robot encounters a robber, and the robber steals the absolute value of coins[i][j] coins.
 * <p>
 * The robot has a special ability to neutralize robbers in at most 2 cells on its path, preventing them from stealing coins in those cells.
 * <p>
 * Note: The robot's total coins can be negative.
 * <p>
 * Return the maximum profit the robot can gain on the route.
 * <p>
 * Example 1:
 * <p>
 * Input: coins = [[0,1,-1],[1,-2,3],[2,-3,4]]
 * <p>
 * Output: 8
 * <p>
 * Explanation:
 * <pre>
 * An optimal path for maximum coins is:
 * Start at (0, 0) with 0 coins (total coins = 0).
 * Move to (0, 1), gaining 1 coin (total coins = 0 + 1 = 1).
 * Move to (1, 1), where there's a robber stealing 2 coins. The robot uses one neutralization here, avoiding the robbery (total coins = 1).
 * Move to (1, 2), gaining 3 coins (total coins = 1 + 3 = 4).
 * Move to (2, 2), gaining 4 coins (total coins = 4 + 4 = 8).
 * </pre>
 * Example 2:
 * <p>
 * Input: coins = [[10,10,10],[10,10,10]]
 * <p>
 * Output: 40
 * <p>
 * Explanation:
 * <pre>
 * An optimal path for maximum coins is:
 * Start at (0, 0) with 10 coins (total coins = 10).
 * Move to (0, 1), gaining 10 coins (total coins = 10 + 10 = 20).
 * Move to (0, 2), gaining another 10 coins (total coins = 20 + 10 = 30).
 * Move to (1, 2), gaining the final 10 coins (total coins = 30 + 10 = 40).
 * </pre>
 * Constraints:
 * <p>
 * m == coins.length
 * <p>
 * n == coins[i].length
 * <p>
 * 1 <= m, n <= 500
 * <p>
 * -1000 <= coins[i][j] <= 1000
 */
class Solution {

    public int maximumAmount(int[][] coins) {
        return dfs(0, 0, 2, new Integer[coins.length][coins[0].length][3], coins);
    }

    private int dfs(int i, int j, int k, Integer[][][] dp, int[][] coins) {
        if (i == coins.length || j == coins[0].length) {
            return Integer.MIN_VALUE;
        }
        int curCoin = coins[i][j];
        if (i == coins.length - 1 && j == coins[0].length - 1) {
            return k > 0 ? Math.max(curCoin, 0) : curCoin;
        }
        if (dp[i][j][k] != null) {
            return dp[i][j][k];
        }
        int res = Math.max(dfs(i + 1, j, k, dp, coins), dfs(i, j + 1, k, dp, coins)) + curCoin;
        if (k > 0 && curCoin < 0) {
            // make curCoin as 0
            res = Math.max(res, Math.max(dfs(i + 1, j, k - 1, dp, coins), dfs(i, j + 1, k - 1, dp, coins)));
        }
        return dp[i][j][k] = res;
    }

    public static void main(String[] args) {
        int[][] coins1 = {{0, 1, -1}, {1, -2, 3}, {2, -3, 4}};
        System.out.println(new Solution().maximumAmount(coins1));
        int[][] coins2 = {{10, 10, 10}, {10, 10, 10}};
        System.out.println(new Solution().maximumAmount(coins2));
        int[][] coins3 = {
                {-6, -15, -16, -8},
                {-10, 11, 6, 16},
                {1, 2, 18, 12},
                {15, 19, 4, 17}
        };
        System.out.println(new Solution().maximumAmount(coins3));
    }
}
