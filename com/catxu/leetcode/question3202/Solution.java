package com.catxu.leetcode.question3202;

/**
 * 3202. Find the Maximum Length of Valid Subsequence II
 */
class Solution {
    public int maximumLength(int[] nums, int k) {
        int ans = 0;
        int[][] f = new int[k][k];
        for (int x : nums) {
            x %= k;
            for (int i = 0; i < k; i++) {
                f[i][x] = f[x][i] + 1;
                ans = Math.max(ans, f[i][x]);
            }
        }
        return ans;
    }
}
