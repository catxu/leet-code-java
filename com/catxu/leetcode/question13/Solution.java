package com.catxu.leetcode.question13;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. Roman to Integer
 * <p>
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value
 * <p>
 * I             1
 * <p>
 * V             5
 * <p>
 * X             10
 * <p>
 * L             50
 * <p>
 * C             100
 * <p>
 * D             500
 * <p>
 * M             1000
 * <p>
 * For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * <p>
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * <p>
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * <p>
 * Given a roman numeral, convert it to an integer.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "III"
 * <p>
 * Output: 3
 * <p>
 * Explanation: III = 3.
 * <p>
 * Example 2:
 * <p>
 * Input: s = "LVIII"
 * <p>
 * Output: 58
 * <p>
 * Explanation: L = 50, V= 5, III = 3.
 * <p>
 * Example 3:
 * <p>
 * Input: s = "MCMXCIV"
 * <p>
 * Output: 1994
 * <p>
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 15
 * <p>
 * s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
 * <p>
 * It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 */
class Solution {

    private static final Map<Character, Integer> ROMAN_NUMERALS = new HashMap<>();

    static {
        ROMAN_NUMERALS.put('I', 1);
        ROMAN_NUMERALS.put('V', 5);
        ROMAN_NUMERALS.put('X', 10);
        ROMAN_NUMERALS.put('L', 50);
        ROMAN_NUMERALS.put('C', 100);
        ROMAN_NUMERALS.put('D', 500);
        ROMAN_NUMERALS.put('M', 1000);
    }

    public int romanToInt(String s) {
        int res = 0;
        char[] romanNums = s.toCharArray();
        int n = romanNums.length;
        for (int i = 0; i < n; i++) {
            int v = ROMAN_NUMERALS.get(romanNums[i]);
            if (i + 1 < n && ROMAN_NUMERALS.get(romanNums[i + 1]) > v) {
                res -= v;
            } else {
                res += v;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("IX"));
        System.out.println(solution.romanToInt("LVIII"));
    }
}
