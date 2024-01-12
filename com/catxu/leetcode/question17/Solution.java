package com.catxu.leetcode.question17;

import java.util.*;

/**
 * 17. Letter Combinations of a Phone Number
 * <p>
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 * <p>
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * <p>
 * Example 1:
 * <p>
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * Example 2:
 * <p>
 * Input: digits = ""
 * Output: []
 * Example 3:
 * <p>
 * Input: digits = "2"
 * Output: ["a","b","c"]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ["2", "9"].
 */
class Solution {
    final static Map<Character, List<Character>> map = new HashMap<>();

    static {
        map.put('2', Arrays.asList('a','b','c'));
        map.put('3', Arrays.asList('d','e','f'));
        map.put('4', Arrays.asList('g','h','i'));
        map.put('5', Arrays.asList('j','k','l'));
        map.put('6', Arrays.asList('m','n','o'));
        map.put('7', Arrays.asList('p','q','r','s'));
        map.put('8', Arrays.asList('t','u','v'));
        map.put('9', Arrays.asList('w','x','y','z'));
    }

/*    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }*/

    List<String> res = new ArrayList<>();
    String digits;

    public List<String> letterCombinations(String digits) {
        this.digits = digits;
        if (!digits.isEmpty()) {
            letterCombinations("", 0);
        }
        return res;
    }

    private void letterCombinations(String currentStr, int index) {
        if (digits.length() == currentStr.length()) {
            res.add(currentStr);
            return;
        }
        List<Character> chars = map.get(digits.charAt(index));
        for (char ch : chars) {
            letterCombinations(currentStr + ch, index + 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.letterCombinations("23"));
//        System.out.println(s.letterCombinations(""));
//        System.out.println(s.letterCombinations("4673"));
    }
}
