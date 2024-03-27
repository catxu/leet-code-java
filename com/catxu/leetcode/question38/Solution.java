package com.catxu.leetcode.question38;

import java.util.ArrayList;
import java.util.List;

/**
 * 38. Count and Say
 * <p>
 * The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
 * <p>
 * countAndSay(1) = "1"
 * countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
 * To determine how you "say" a digit string, split it into the minimal number of substrings such that each substring contains exactly one unique digit. Then for each substring, say the number of digits, then say the digit. Finally, concatenate every said digit.
 * <p>
 * For example, the saying and conversion for digit string "3322251":
 * <p>
 * Given a positive integer n, return the n(th) term of the count-and-say sequence.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 1
 * Output: "1"
 * Explanation: This is the base case.
 * Example 2:
 * <p>
 * Input: n = 4
 * Output: "1211"
 * Explanation:
 * countAndSay(1) = "1"
 * countAndSay(2) = say "1" = one 1 = "11"
 * countAndSay(3) = say "11" = two 1's = "21"
 * countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 30
 */
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countAndSay(1));
        System.out.println(solution.countAndSay(4));
    }

    public String countAndSay(int n) {
        String num = "1";
        if (n <= 1) {
            return num;
        }
        for (int i = 2; i <= n; i++) {
            num = mapDigitsToString(mapStringToDigits(num));
        }
        return num;
    }

    public List<Integer[]> mapStringToDigits(String num) {
        char prev = num.charAt(0);
        int count = 0;
        List<Integer[]> integers = new ArrayList<>();
        char[] chars = num.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            if (chars[i] == prev) {
                count++;
            } else {
                integers.add(new Integer[]{count, Character.digit(prev, 10)});
                prev = chars[i];
                count = 1;
            }
            if (i == length - 1) {
                integers.add(new Integer[]{count, Character.digit(prev, 10)});
            }
        }
        return integers;
    }

    public String mapDigitsToString(List<Integer[]> digits) {
        StringBuilder sb = new StringBuilder();
        for (Integer[] pair : digits) {
            sb.append(pair[0]).append(pair[1]);
        }
        return sb.toString();
    }
}
