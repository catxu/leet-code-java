package com.catxu.leetcode.question2264;

/**
 * 2264. Largest 3-Same-Digit Number in String
 * <p>
 * You are given a string num representing a large integer. An integer is good if it meets the following conditions:
 * <p>
 * It is a substring of num with length 3.
 * <p>
 * It consists of only one unique digit.
 * <p>
 * Return the maximum good integer as a string or an empty string "" if no such integer exists.
 * <p>
 * Note:
 * <p>
 * A substring is a contiguous sequence of characters within a string.
 * <p>
 * There may be leading zeroes in num or a good integer.
 * <p>
 * Example 1:
 * <pre>
 * Input: num = "6777133339"
 * Output: "777"
 * Explanation: There are two distinct good integers: "777" and "333".
 * "777" is the largest, so we return "777".
 * </pre>
 * Example 2:
 * <pre>
 * Input: num = "2300019"
 * Output: "000"
 * Explanation: "000" is the only good integer.
 * </pre>
 * Example 3:
 * <pre>
 * Input: num = "42352338"
 * Output: ""
 * Explanation: No substring of length 3 consists of only one unique digit. Therefore, there are no good integers.
 * </pre>
 * <p>
 * Constraints:
 * <p>
 * 3 <= num.length <= 1000
 * <p>
 * num only consists of digits.
 */
class Solution {
    public String largestGoodInteger(String num) {
        for (char d = '9'; d >= '0'; d--) {
            String s = String.valueOf(d).repeat(3);
            if (num.contains(s)) {
                return s;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largestGoodInteger("6777133339"));
        System.out.println(new Solution().largestGoodInteger("2300019"));
        System.out.println(new Solution().largestGoodInteger("42352338"));
    }
}