package com.catxu.leetcode.question8;

import java.util.Map;

/**
 * 8. String to Integer (atoi)
 * <p>
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
 * <p>
 * The algorithm for myAtoi(string s) is as follows:
 * <p>
 * Read in and ignore any leading whitespace.
 * <p>
 * Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
 * <p>
 * Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
 * <p>
 * Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
 * <p>
 * If the integer is out of the 32-bit signed integer range [-2<sup>31</sup>, 2<sup>31</sup> - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -2<sup>31</sup> should be clamped to -2<sup>31</sup>, and integers greater than 2<sup>31</sup> - 1 should be clamped to 2<sup>31</sup> - 1.
 * <p>
 * Return the integer as the final result.
 * <p>
 * Note:
 * <p>
 * Only the space character ' ' is considered a whitespace character.
 * <p>
 * Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
 * <p>
 * Example 1:
 * <pre>
 * Input: s = "42"
 * Output: 42
 * Explanation: The underlined characters are what is read in, the caret is the current reader position.
 * Step 1: "42" (no characters read because there is no leading whitespace)
 * Step 2: "42" (no characters read because there is neither a '-' nor '+')
 * Step 3: "42" ("42" is read in)
 * The parsed integer is 42.
 * Since 42 is in the range [-2<sup>31</sup>, 2<sup>31</sup> - 1], the final result is 42.
 * </pre>
 * Example 2:
 * <pre>
 * Input: s = "   -42"
 * Output: -42
 * Explanation:
 * Step 1: "   -42" (leading whitespace is read and ignored)
 * Step 2: "   -42" ('-' is read, so the result should be negative)
 * Step 3: "   -42" ("42" is read in)
 * The parsed integer is -42.
 * Since -42 is in the range [-2<sup>31</sup>, 2<sup>31</sup> - 1], the final result is -42.
 * </pre>
 * Example 3:
 * <pre>
 * Input: s = "4193 with words"
 * Output: 4193
 * Explanation:
 * Step 1: "4193 with words" (no characters read because there is no leading whitespace)
 * Step 2: "4193 with words" (no characters read because there is neither a '-' nor '+')
 * Step 3: "4193 with words" ("4193" is read in; reading stops because the next character is a non-digit)
 * The parsed integer is 4193.
 * Since 4193 is in the range [-2<sup>31</sup>, 2<sup>31</sup> - 1], the final result is 4193.
 * </pre>
 * Constraints:
 * <pre>
 * 0 <= s.length <= 200
 * s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.
 * </pre>
 */
class Solution {
    public int myAtoi(String str) {
        Automaton automaton = new Automaton();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            automaton.get(str.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myAtoi("42"));
        System.out.println(new Solution().myAtoi("   -42"));
        System.out.println(new Solution().myAtoi("4193 with words"));
    }
}

class Automaton {
    public int sign = 1;
    public long ans = 0;
    private String state = "start";
    private final Map<String, String[]> table = Map.of(
            "start", new String[]{"start", "signed", "in_number", "end"},
            "signed", new String[]{"end", "end", "in_number", "end"},
            "in_number", new String[]{"end", "end", "in_number", "end"},
            "end", new String[]{"end", "end", "end", "end"}
    );

    public void get(char c) {
        state = table.get(state)[get_col(c)];
        if ("in_number".equals(state)) {
            ans = ans * 10 + c - '0';
            ans = sign == 1 ? Math.min(ans, Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
        } else if ("signed".equals(state)) {
            sign = c == '+' ? 1 : -1;
        }
    }

    private int get_col(char c) {
        if (c == ' ') {
            return 0;
        }
        if (c == '+' || c == '-') {
            return 1;
        }
        if (Character.isDigit(c)) {
            return 2;
        }
        return 3;
    }
}