package com.catxu.leetcode.question256;

import java.util.Arrays;

/**
 * 256. Paint House
 * <p>
 * There is a row of n houses, where each house can be painted one of three colors: red, blue, or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
 * <p>
 * The cost of painting each house with a certain color is represented by an n x 3 cost matrix costs.
 * <p>
 * For example, costs[0][0] is the cost of painting house 0 with the color red; costs[1][2] is the cost of painting house 1 with color green, and so on...
 * Return the minimum cost to paint all houses.
 * <p>
 * Example 1:
 * <pre>
 * Input: costs = [[17,2,17],[16,16,5],[14,3,19]]
 * Output: 10
 * Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
 * Minimum cost: 2 + 5 + 3 = 10.
 * </pre>
 * Example 2:
 * <pre>
 * Input: costs = [[7,6,2]]
 * Output: 2
 * </pre>
 * Constraints:
 * <pre>
 * costs.length == n
 * costs[i].length == 3
 * 1 <= n <= 100
 * 1 <= costs[i][j] <= 20
 * </pre>
 */
class Solution {
    public int minCost(int[][] cost) {
        int n = cost.length;
        int m = 3;
        // 第 i 栋房子 paint 成 x 色的最小花费
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0) {
                    dp[i][j] = cost[i][j];
                    continue;
                }
                for (int k = 0; k < m; k++) {
                    if (k != j) { // 与前一栋房子颜色不同
                        // dp[i][k] = 前一栋最小花费 + paint 成 k 色的花费
                        dp[i][k] = Math.min(dp[i][j], dp[i - 1][j] + cost[i][k]);
                    }
                }
            }
        }
        return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    }


    public static void main(String[] args) {
        System.out.println(new Solution().minCost(new int[][]{
                {17, 2, 17}, {16, 16, 5}, {14, 3, 19}
        }));
        System.out.println(new Solution().minCost(new int[][]{
                {7, 6, 2}
        }));
    }
}
