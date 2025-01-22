package com.catxu.leetcode.question2218;

import java.util.Arrays;
import java.util.List;

/**
 * 2218. Maximum Value of K Coins From Piles
 * <p>
 * There are n piles of coins on a table. Each pile consists of a positive number of coins of assorted denominations.
 * <p>
 * In one move, you can choose any coin on top of any pile, remove it, and add it to your wallet.
 * <p>
 * Given a list piles, where piles[i] is a list of integers denoting the composition of the ith pile from top to bottom, and a positive integer k, return the maximum total value of coins you can have in your wallet if you choose exactly k coins optimally.
 * <p>
 * Example 1:
 * <pre>
 * Input: piles = [[1,100,3],[7,8,9]], k = 2
 * Output: 101
 * Explanation:
 * The above diagram shows the different ways we can choose k coins.
 * The maximum total we can obtain is 101.
 * </pre>
 * Example 2:
 * <pre>
 * Input: piles = [[100],[100],[100],[100],[100],[100],[1,1,1,1,1,1,700]], k = 7
 * Output: 706
 * Explanation:
 * The maximum total can be obtained if we choose all coins from the last pile.
 * </pre>
 * Constraints:
 * <pre>
 * n == piles.length
 * 1 <= n <= 1000
 * 1 <= piles[i][j] <= 10<sup>5</sup>
 * 1 <= k <= sum(piles[i].length) <= 2000
 * </pre>
 */
class Solution {

    /*
    Given N items where each item has some weight and profit associated with it and also given a bag with capacity W,
    [i.e., the bag can hold at most W weight in it].
    The task is to put the items into the bag such that the sum of profits associated with them is the maximum possible.

    Note: The constraint here is we can either put an item completely into the bag or cannot put it at all
    [It is not possible to put a part of an item into the bag].

    Input: N = 3, W = 4, profit[] = {1, 2, 3}, weight[] = {4, 5, 1}
    Output: 3
    Explanation: There are two items which have weight less than or equal to 4.
    If we select the item with weight 4, the possible profit is 1.
    And if we select the item with weight 1, the possible profit is 3.
    So the maximum possible profit is 3. Note that we cannot put both the items with
    weight 4 and 1 together as the capacity of the bag is 4.

    Input: N = 3, W = 3, profit[] = {1, 2, 3}, weight[] = {4, 5, 6}
    Output: 0
     */
    public int knapsack(int n, int w, int[] profit, int[] weight) {
        return dfs(n, w, profit, weight, 0, 0, 0);
    }

    private int dfs(int n, int w, int[] profit, int[] weight, int start, int curWeight, int curProfit) {
        if (start >= n || curWeight > w) {
            return curProfit;
        }
        // Option 1: Don't include the current item
        int maxProfit = dfs(n, w, profit, weight, start + 1, curWeight, curProfit);
        // Option 2: Include the current item (if weight allows)
        if (curWeight + weight[start] <= w) {
            maxProfit = Math.max(maxProfit, dfs(n, w, profit, weight, start + 1, curWeight + weight[start], curProfit + profit[start]));
        }
        return maxProfit;
    }

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        int[][] dp = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(piles, dp, 0, k, n);
    }

    public int dfs(List<List<Integer>> piles, int[][] dp, int i, int coins, int n) {
        if (i == n) {
            return 0;
        }
        if (dp[i][coins] != -1) {
            return dp[i][coins];
        }
        // 不选 跳过当前 pile
        dp[i][coins] = dfs(piles, dp, i + 1, coins, n);
        int curPile = 0;
        for (int j = 0; j < Math.min(piles.get(i).size(), coins); j++) {
            curPile += piles.get(i).get(j);
            // 选 从当前 pile 中取 0 - boundary 次，并比较从其他 pile 取 0 - boundary 次
            dp[i][coins] = Math.max(dp[i][coins], curPile + dfs(piles, dp, i + 1, coins - j - 1, n));
        }
        return dp[i][coins];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().knapsack(3, 4, new int[]{1, 2, 3}, new int[]{4, 5, 1}));
        System.out.println(new Solution().knapsack(3, 3, new int[]{1, 2, 3}, new int[]{4, 5, 6}));

        List<Integer> l1_1 = List.of(1, 100, 3);
        List<Integer> l1_2 = List.of(7, 8, 9);
        List<List<Integer>> piles1 = List.of(l1_1, l1_2);
        System.out.println(new Solution().maxValueOfCoins(piles1, 2));
        List<Integer> l2_1 = List.of(100);
        List<Integer> l2_7 = List.of(1, 1, 1, 1, 1, 1, 700);
        List<List<Integer>> piles2 = List.of(l2_1, l2_1, l2_1, l2_1, l2_1, l2_1, l2_7);
        System.out.println(new Solution().maxValueOfCoins(piles2, 7));
    }
}
