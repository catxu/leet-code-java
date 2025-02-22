package com.catxu.leetcode.question191;

/**
 * 191. Number of 1 Bits
 */
class Solution {
    public int hammingWeight(int n) {
        return hammingWeight(n, 0);
    }

    private int hammingWeight(int n, int res) {
        if (n == 0) {
            return res;
        }
        res += (n & 1);
        return hammingWeight(n >> 1, res);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().hammingWeight(11));
        System.out.println(new Solution().hammingWeight(128));
        System.out.println(new Solution().hammingWeight(2147483645));
    }
}
