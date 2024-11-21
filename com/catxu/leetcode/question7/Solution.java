package com.catxu.leetcode.question7;

/**
 * 7. Reverse Integer
 * <p>
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-2<sup>31</sup>, 2<sup>31</sup> - 1], then return 0.
 * <p>
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 * <p>
 * Example 1:
 * <p>
 * Input: x = 123
 * <p>
 * Output: 321
 * <p>
 * Example 2:
 * <p>
 * Input: x = -123
 * <p>
 * Output: -321
 * <p>
 * Example 3:
 * <p>
 * Input: x = 120
 * <p>
 * Output: 21
 * <p>
 * Constraints:
 * <p>
 * -2<sup>31</sup> <= x <= 2<sup>31</sup> - 1
 */
class Solution {

    public static int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int temp = res * 10 + x % 10;
            if (temp / 10 != res) { // overflow
                return 0;
            }
            res = temp;
            x /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-2138473412));
        System.out.println(-2147483648);
        System.out.println(Integer.MIN_VALUE % 10);
//        System.out.println(Math.abs(Integer.MIN_VALUE));
//        System.out.println(Math.abs(Integer.MIN_VALUE + 1));
    }
}