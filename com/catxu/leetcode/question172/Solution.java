package com.catxu.leetcode.question172;

/**
 * 172. Factorial Trailing Zeroes
 */
class Solution {
    public int trailingZeroes(int n) {
        int ans = 0;
        while (n != 0) {
            n /= 5;
            ans += n;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().trailingZeroes(5));
        System.out.println(new Solution().trailingZeroes(10));
        System.out.println(new Solution().trailingZeroes(20));
        System.out.println(new Solution().trailingZeroes(25));
        System.out.println(new Solution().trailingZeroes(10000));
    }
}
