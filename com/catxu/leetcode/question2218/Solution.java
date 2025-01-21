package com.catxu.leetcode.question2218;

import java.util.Arrays;
import java.util.List;

/**
 * 2218. Maximum Value of K Coins From Piles
 */
class Solution {

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
