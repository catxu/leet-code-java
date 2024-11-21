package com.catxu.leetcode.question8;

import java.util.HashMap;
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
 * If the integer is out of the 32-bit signed integer range [-2^31, 2^31 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -2^31 should be clamped to -2^31, and integers greater than 2^31 - 1 should be clamped to 2^31 - 1.
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
 * <p>
 * Input: s = "42"
 * <p>
 * Output: 42
 * <p>
 * Explanation: The underlined characters are what is read in, the caret is the current reader position.
 * <p>
 * Step 1: "42" (no characters read because there is no leading whitespace)
 * <p>
 * ^
 * <p>
 * Step 2: "42" (no characters read because there is neither a '-' nor '+')
 * <p>
 * ^
 * <p>
 * Step 3: "42" ("42" is read in)
 * <p>
 * ^
 * <p>
 * The parsed integer is 42.
 * <p>
 * Since 42 is in the range [-2<sup>31</sup>, 2<sup>31</sup> - 1], the final result is 42.
 * <p>
 * Example 2:
 * <p>
 * Input: s = "   -42"
 * <p>
 * Output: -42
 * <p>
 * Explanation:
 * <p>
 * Step 1: "   -42" (leading whitespace is read and ignored)
 * <p>
 * ^
 * <p>
 * Step 2: "   -42" ('-' is read, so the result should be negative)
 * <p>
 * ^
 * <p>
 * Step 3: "   -42" ("42" is read in)
 * <p>
 * ^
 * <p>
 * The parsed integer is -42.
 * <p>
 * Since -42 is in the range [-2<sup>31</sup>, 2<sup>31</sup> - 1], the final result is -42.
 * <p>
 * Example 3:
 * <p>
 * Input: s = "4193 with words"
 * <p>
 * Output: 4193
 * <p>
 * Explanation:
 * <p>
 * Step 1: "4193 with words" (no characters read because there is no leading whitespace)
 * <p>
 * ^
 * <p>
 * Step 2: "4193 with words" (no characters read because there is neither a '-' nor '+')
 * <p>
 * ^
 * <p>
 * Step 3: "4193 with words" ("4193" is read in; reading stops because the next character is a non-digit)
 * <p>
 * ^
 * <p>
 * The parsed integer is 4193.
 * <p>
 * Since 4193 is in the range [-2<sup>31</sup>, 2<sup>31</sup> - 1], the final result is 4193.
 * <p>
 * Constraints:
 * <p>
 * 0 <= s.length <= 200
 * s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.
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
}

class Automaton {
    public int sign = 1;
    public long ans = 0;
    private String state = "start";
    private Map<String, String[]> table = new HashMap<String, String[]>() {{
        put("start", new String[]{"start", "signed", "in_number", "end"});
        put("signed", new String[]{"end", "end", "in_number", "end"});
        put("in_number", new String[]{"end", "end", "in_number", "end"});
        put("end", new String[]{"end", "end", "end", "end"});
    }};

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