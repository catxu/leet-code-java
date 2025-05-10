package com.catxu.leetcode.question322;

import java.util.Arrays;

/**
 * 322. Coin Change
 * <p>
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * <p>
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * You may assume that you have an infinite number of each kind of coin.
 * <p>
 * Example 1:
 * <pre>
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * </pre>
 * Example 2:
 * <pre>
 * Input: coins = [2], amount = 3
 * Output: -1
 * </pre>
 * Example 3:
 * <pre>
 * Input: coins = [1], amount = 0
 * Output: 0
 * </pre>
 * Constraints:
 * <pre>
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 2<sup>31</sup> - 1
 * 0 <= amount <= 10<sup>4</sup>
 * </pre>
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        int unreachableAmt = amount + 1;
        int[] dp = new int[unreachableAmt];
        Arrays.fill(dp, unreachableAmt);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) { // 完全背包 每种物品可以取任意次
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(s.coinChange(new int[]{2}, 3));
        System.out.println(s.coinChange(new int[]{1}, 0));
        System.out.println(s.coinChange(new int[]{2, 5, 7}, 27));
    }
}
