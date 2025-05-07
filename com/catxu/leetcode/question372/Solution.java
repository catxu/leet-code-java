package com.catxu.leetcode.question372;

/**
 * 372. Super Pow
 */
class Solution {

    private static final int MOD = 1377;

    public int superPow(int a, int[] b) {
        return dfs(a, b, b.length - 1);
    }

    private int dfs(int a, int[] b, int index) {
        if (index == -1) return 1;
        return fastPow(dfs(a, b, index - 1), 10) * fastPow(a, b[index]) % MOD;
    }

    private int fastPow(int a, int n) {
        if (n == 0) {
            return 1;
        }
        a %= MOD;
        int half = fastPow(a, n / 2) % MOD;
        return n % 2 == 0 ? (half * half) % MOD : (((half * half) % MOD) * a) % MOD;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().superPow(2, new int[]{1, 0}));
        System.out.println(new Solution().superPow(2, new int[]{4, 3, 3, 8, 5, 2}));
    }
}
