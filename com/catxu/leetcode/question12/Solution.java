package com.catxu.leetcode.question12;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 12. Integer to Roman
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
 * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * <p>
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * <p>
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * <p>
 * Given an integer, convert it to a roman numeral.
 * <p>
 * Example 1:
 * <p>
 * Input: num = 3
 * <p>
 * Output: "III"
 * <p>
 * Explanation: 3 is represented as 3 ones.
 * <p>
 * Example 2:
 * <p>
 * Input: num = 58
 * <p>
 * Output: "LVIII"
 * <p>
 * Explanation: L = 50, V = 5, III = 3.
 * <p>
 * Example 3:
 * <p>
 * Input: num = 1994
 * <p>
 * Output: "MCMXCIV"
 * <p>
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * <p>
 * Constraints:
 * <p>
 * 1 <= num <= 3999
 */
class Solution {
    static Map<Integer, String> intRomanMap = new HashMap<>();

    static {
        intRomanMap.put(1, "I");
        intRomanMap.put(4, "IV");
        intRomanMap.put(5, "V");
        intRomanMap.put(9, "IX");
        intRomanMap.put(10, "X");
        intRomanMap.put(40, "XL");
        intRomanMap.put(50, "L");
        intRomanMap.put(90, "XC");
        intRomanMap.put(100, "C");
        intRomanMap.put(400, "CD");
        intRomanMap.put(500, "D");
        intRomanMap.put(900, "CM");
        intRomanMap.put(1000, "M");
    }

    public String intToRoman(int num) {
        // last-in first-out
        Stack<String> stack = new Stack<>();
        int carry = 1;
        do {
            int digit = num % 10 * carry;
            if (intRomanMap.get(digit) != null) {
                stack.push(intRomanMap.get(digit));
            } else {
                if (digit != 0) {
                    String roman = digit > 5 * carry ? intRomanMap.get(5 * carry) : intRomanMap.get(carry);
                    int diff = (digit / carry > 5) ? (digit / carry - 5) : (digit / carry - 1);
                    for (int i = 0; i < diff; ++i) {
                        roman += intRomanMap.get(carry);
                    }
                    stack.push(roman);
                }
            }
            carry *= 10;
            num /= 10;
        } while (num != 0);
        StringBuilder ans = new StringBuilder();
        while (!stack.empty()) ans.append(stack.pop());
        return ans.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

//        System.out.println(solution.intToRoman(3));
//        System.out.println(solution.intToRoman(10));
//        System.out.println(solution.intToRoman(27));
//        System.out.println(solution.intToRoman(30));
//        System.out.println(solution.intToRoman(33));
//        System.out.println(solution.intToRoman(58));
//        System.out.println(solution.intToRoman(3001));
        System.out.println(solution.intToRoman(1994));
//        System.out.println(solution.intToRoman(3333));
//        System.out.println(solution.intToRoman(3888));
//        System.out.println(solution.intToRoman(3999));
    }
}
