package com.catxu.leetcode.question69;

/**
 * 69. Sqrt(x)
 * <p>
 * Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
 * <p>
 * You must not use any built-in exponent function or operator.
 * <p>
 * For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 * <p>
 * Example 1:
 * <p>
 * Input: x = 4
 * <p>
 * Output: 2
 * <p>
 * Explanation: The square root of 4 is 2, so we return 2.
 * <p>
 * Example 2:
 * <p>
 * Input: x = 8
 * <p>
 * Output: 2
 * <p>
 * Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
 * <p>
 * Constraints:
 * <p>
 * 0 <= x <= 2<sup>31</sup> - 1
 */
class Solution {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int l = 0;
        int r = x;
        int mid = (l + r) / 2;
        while (l <= r) {
            long product = (long) mid * mid;
            if (product > x) {
                r = mid - 1;
            } else if (product < x) {
                l = mid + 1;
            } else {
                return mid;
            }
            mid = (l + r) / 2;
        }
        return r;
    }

    // 当退出循环时，l 必然 大于 r。可能有两种情况，r 减少或者 l 增加导致循环退出。
    // 当 r 减少，必然是因为 product 大于 x，所以 r 即为正确答案
    // 当 l 增加，必然是因为 product 小于 x，
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.mySqrt(0));
        System.out.println(s.mySqrt(1));
        System.out.println(s.mySqrt(2));
        System.out.println(s.mySqrt(4));
        System.out.println(s.mySqrt(8));
        System.out.println(s.mySqrt(Integer.MAX_VALUE));
    }
}