package com.catxu.leetcode.question13;

import java.util.HashMap;
import java.util.Map;

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
