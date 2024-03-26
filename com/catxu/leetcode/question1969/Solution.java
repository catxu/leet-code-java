package com.catxu.leetcode.question1969;

/**
 * 1969. Minimum Non-Zero Product of the Array Elements
 * <p>
 * You are given a positive integer p. Consider an array nums (1-indexed) that consists of the integers in the inclusive range [1, 2^p - 1] in their binary representations. You are allowed to do the following operation any number of times:
 * <p>
 * - Choose two elements x and y from nums.
 * <p>
 * - Choose a bit in x and swap it with its corresponding bit in y. Corresponding bit refers to the bit that is in the same position in the other integer.
 * <p>
 * For example, if x = 1101 and y = 0011, after swapping the 2nd bit from the right, we have x = 1111 and y = 0001.
 * <p>
 * Find the minimum non-zero product of nums after performing the above operation any number of times. Return this product modulo 10^9 + 7.
 * <p>
 * Note: The answer should be the minimum product before the modulo operation is done.
 * <p>
 * Example 1:
 * <p>
 * Input: p = 1
 * Output: 1
 * Explanation: nums = [1].
 * There is only one element, so the product equals that element.
 * <p>
 * Example 2:
 * <p>
 * Input: p = 2
 * Output: 6
 * Explanation: nums = [01, 10, 11].
 * Any swap would either make the product 0 or stay the same.
 * Thus, the array product of 1 * 2 * 3 = 6 is already minimized.
 * <p>
 * Example 3:
 * <p>
 * Input: p = 3
 * Output: 1512
 * Explanation: nums = [001, 010, 011, 100, 101, 110, 111]
 * - In the first operation we can swap the leftmost bit of the second and fifth elements.
 * <p>
 * - The resulting array is [001, 110, 011, 100, 001, 110, 111].
 * <p>
 * - In the second operation we can swap the middle bit of the third and fourth elements.
 * <p>
 * - The resulting array is [001, 110, 001, 110, 001, 110, 111].
 * <p>
 * The array product is 1 * 6 * 1 * 6 * 1 * 6 * 7 = 1512, which is the minimum possible product.
 * <p>
 * Constraints:
 * <p>
 * 1 <= p <= 60
 */
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minNonZeroProduct(1));
        System.out.println(solution.minNonZeroProduct(2));
        System.out.println(solution.minNonZeroProduct(3));
        // 581202553
        System.out.println(solution.minNonZeroProduct(4));
        // 202795991
        System.out.println(solution.minNonZeroProduct(5));
        // 945196305
        System.out.println(solution.minNonZeroProduct(30));
        // 112322054
        System.out.println(solution.minNonZeroProduct(35));
        // 65332879
        System.out.println(solution.minNonZeroProduct(55));
    }

    private static final int M = 1000000007;

    /**
     * 快速幂取余
     *
     * @param x      底数
     * @param p      指数
     * @param modulo 模
     * @return
     */
    private long fastPowModulo(long x, long p, int modulo) {
        long result = 1L;
        while (p != 0) {
            if ((p & 1) == 1) {
                result = ((result % modulo) * (x % modulo)) % modulo;
            }
            x = ((x % modulo) * (x % modulo)) % modulo;
            p >>= 1;
        }
        return result % modulo;
    }

    public int minNonZeroProduct(int p) {
        // long base = (long) Math.pow(2, p) - 2;
        // 注意精度丢失
        long base = (long) Math.pow(2, p) - 2;
        long nums = base + 1;
        long product = ((fastPowModulo(base, nums / 2, M) % M) * (nums % M));
        // return (int) product % M;
        // 模运算优先级 小于 type-cast
        return (int) (product % M);
    }

}
