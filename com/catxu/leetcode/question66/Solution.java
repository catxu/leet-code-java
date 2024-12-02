package com.catxu.leetcode.question66;

import java.util.Arrays;

/**
 * 66. Plus One
 * <p>
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
 * <p>
 * Increment the large integer by one and return the resulting array of digits.
 * <p>
 * Example 1:
 * <p>
 * Input: digits = [1,2,3]
 * <p>
 * Output: [1,2,4]
 * <p>
 * Explanation: The array represents the integer 123. Incrementing by one gives 123 + 1 = 124.Thus, the result should be [1,2,4].
 * <p>
 * Example 2:
 * <p>
 * Input: digits = [4,3,2,1]
 * <p>
 * Output: [4,3,2,2]
 * <p>
 * Explanation: The array represents the integer 4321. Incrementing by one gives 4321 + 1 = 4322. Thus, the result should be [4,3,2,2].
 * <p>
 * Example 3:
 * <p>
 * Input: digits = [9]
 * <p>
 * Output: [1,0]
 * <p>
 * Explanation: The array represents the integer 9. Incrementing by one gives 9 + 1 = 10. Thus, the result should be [1,0].
 * <p>
 * Constraints:
 * <p>
 * 1 <= digits.length <= 100
 * <p>
 * 0 <= digits[i] <= 9
 * <p>
 * digits does not contain any leading 0's.
 */
class Solution {
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        digits[i] = digits[i] + 1;
        int carry = digits[i] / 10;
        digits[i] = digits[i] % 10;
        // 不涉及进位，直接返回
        if (carry == 0) {
            return digits;
        }

        // 需要进位，数组长度为1的情况特殊处理
        if (i == 0) {
            return new int[]{1, digits[0]};
        }
        while (carry > 0 && --i > 0) {
            int temp = digits[i] + carry;
            carry = temp / 10;
            digits[i] = temp % 10;
        }

        int lastNum = digits[0] + carry;
        if (lastNum < 10) {
            digits[0] = lastNum;
            return digits;
        }
        int[] target = new int[digits.length + 1];
        target[0] = 1;
        digits[0] = lastNum % 10;
        System.arraycopy(digits, 0, target, 1, digits.length);
        return target;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(s.plusOne(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(s.plusOne(new int[]{9})));
    }
}
