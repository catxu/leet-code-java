package com.catxu.leetcode.question3307;

/**
 * 3307. Find the K-th Character in String Game II
 */
class Solution {
    public char kthCharacter(long k, int[] operations) {
        return dfs(k, operations, 63 - Long.numberOfLeadingZeros(k - 1));
    }

    private char dfs(long k, int[] operations, int i) {
        if (i < 0) return 'a';
        if (k <= 1L << i) return dfs(k, operations, i - 1); // k 在左半段
        int op = operations[i];
        char ans = dfs(k - (1L << i), operations, i - 1);
        return (char) ('a' + (ans - 'a' + op) % 26);
    }
}
