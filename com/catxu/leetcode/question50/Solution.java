package com.catxu.leetcode.question50;

/**
 * 50. Pow(x, n)
 * <p>
 * Implement pow(x, n), which calculates x raised to the power n (i.e., x<sup>n</sup>).
 * <p>
 * Example 1:
 * <pre>
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 * </pre>
 * Example 2:
 * <pre>
 * Input: x = 2.10000, n = 3
 * Output: 9.26100
 * </pre>
 * Example 3:
 * <pre>
 * Input: x = 2.00000, n = -2
 * Output: 0.25000
 * Explanation: 2<sup>-2</sup> = 1/2<sup>2</sup> = 1/4 = 0.25
 * </pre>
 * Constraints:
 * <pre>
 * -100.0 < x < 100.0
 * -2<sup>31</sup> <= n <= 2<sup>31</sup>-1
 * n is an integer.
 * Either x is not zero or n > 0.
 * -10<sup>4</sup> <= x<sup>n</sup> <= 10<sup>4</sup>
 * </pre>
 */
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myPow(2, 10));
        System.out.println(solution.myPow(2.1, 3));
        System.out.println(solution.myPow(2, -2));
        System.out.println(solution.myPow(2, 0));
        System.out.println(solution.myPow(-1, Integer.MAX_VALUE));
        System.out.println(solution.myPow(-1, Integer.MIN_VALUE));
    }

    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            N = -N;
            x = 1 / x;
        }
        return fastPow(x, N);
    }

    private double fastPow(double x, long n) {
        double result = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                result *= x;
            }
            x *= x;
            n = n >> 1;
        }
        return result;
    }

    private double fastPowRecursive(double x, long n) {
        if (n == 0) {
            return 1;
        }
        double half = fastPowRecursive(x, n / 2);
        return n % 2 == 0 ? half * half : half * half * x;
    }
}
