package com.catxu.leetcode.question877;

/**
 * 877. Stone Game
 */
class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        // 定义dp[l][r]为考虑区间[l,r]，在双方都做最好选择的情况下，先手与后手的最大得分差值为多少
        // dp[l][r] = (当前玩家在 [l, r] 区间获得的分数) - (对手在 [l + 1, r] | [l, r - 1] 区间获得的分数)
        int[][] dp = new int[n + 2][n + 2];
        for (int len = 1; len <= n; len++) { // 枚举区间长度
            for (int l = 1; l + len - 1 <= n; l++) { // 枚举左端点
                int r = l + len - 1; // 计算右端点
                int a = piles[l - 1] - dp[l + 1][r]; // 表示当前玩家在区间 [l, r] 选择拿左边石子后，能获得的最大分数差
                int b = piles[r - 1] - dp[l][r - 1]; // 表示当前玩家在区间 [l, r] 选择拿右边石子后，能获得的最大分数差
                dp[l][r] = Math.max(a, b);
            }
        }
        return dp[1][n] > 0; // 在整个游戏区间 [1, n] 中，先手玩家能获得的最大分数差是否大于 0
    }

    public static void main(String[] args) {
        System.out.println(new Solution().stoneGame(new int[]{5, 3, 4, 5}));
        System.out.println(new Solution().stoneGame(new int[]{1, 7, 6, 1}));
    }
}