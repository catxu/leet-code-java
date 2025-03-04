package com.catxu.leetcode.question29;

/**
 * 29. Divide Two Integers
 * <p>
 * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
 * <p>
 * The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.
 * <p>
 * Return the quotient after dividing dividend by divisor.
 * <p>
 * Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−2<sup>31</sup>, 2<sup>31</sup> − 1]. For this problem, if the quotient is strictly greater than 2<sup>31</sup> - 1, then return 2<sup>31</sup> - 1, and if the quotient is strictly less than -2<sup>31</sup>, then return -2<sup>31</sup>.
 * <p>
 * Example 1:
 * <pre>
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Explanation: 10/3 = 3.33333.... which is truncated to 3.
 * </pre>
 * Example 2:
 * <pre>
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Explanation: 7/-3 = -2.33333.... which is truncated to -2.
 * </pre>
 * Constraints:
 * <pre>
 * -2<sup>31</sup> <= dividend, divisor <= 2<sup>31</sup> - 1
 * divisor != 0
 * </pre>
 */
class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        long d = Math.abs((long) dividend);
        long dv = Math.abs((long) divisor);
        int res = 0;
        long temp;
        while (d >= dv) {
            temp = dv;
            int coefficient = 1;
            while (d >= temp) {
                d -= temp;
                res += coefficient;
                coefficient += coefficient;
                temp += temp;
            }
        }
        if ((dividend > 0 && divisor < 0) || (divisor > 0 && dividend < 0)) {
            res = -res;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.divide(10, 3));
        System.out.println(s.divide(7, -3));
        System.out.println(s.divide(0, -1));
        System.out.println(s.divide(Integer.MIN_VALUE, -1));
        System.out.println(s.divide(Integer.MIN_VALUE, 1));
        System.out.println(s.divide(2147483647, 2));
    }
}
