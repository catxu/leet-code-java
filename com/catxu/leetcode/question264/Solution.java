package com.catxu.leetcode.question264;

/**
 * 264. Ugly Number II
 */
class Solution {
    public int nthUglyNumber(int n) {
        int[] ans = new int[n + 1];
        ans[1] = 1;
        for (int i2 = 1, i3 = 1, i5 = 1, i = 2; i <= n; i++) {
            int a = ans[i2] * 2, b = ans[i3] * 3, c = ans[i5] * 5;
            int min = Math.min(a, Math.min(b, c));
            if (min == a) i2++;
            if (min == b) i3++;
            if (min == c) i5++;
            ans[i] = min;
        }
        return ans[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().nthUglyNumber(10));
        System.out.println(new Solution().nthUglyNumber(12));
    }
}
