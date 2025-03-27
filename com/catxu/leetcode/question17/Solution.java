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
 * <pre>
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * </pre>
 * Example 2:
 * <pre>
 * Input: digits = ""
 * Output: []
 * </pre>
 * Example 3:
 * <pre>
 * Input: digits = "2"
 * Output: ["a","b","c"]
 * </pre>
 * Constraints:
 * <pre>
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ["2", "9"].
 * </pre>
 */
class Solution {

    public List<String> letterCombinations(String digits) {
        Map<Character, List<Character>> map = new HashMap<>();
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));

        List<String> ans = new ArrayList<>();
        if (!digits.isEmpty()) {
            dfs(ans, new StringBuilder(), 0, map, digits);
        }
        return ans;
    }

    private void dfs(List<String> res, StringBuilder state, int index, Map<Character, List<Character>> dict, String digits) {
        if (state.length() == digits.length()) {
            res.add(state.toString());
            return;
        }
        List<Character> chs = dict.get(digits.charAt(index));
        for (char ch : chs) {
            state.append(ch);
            dfs(res, state, index + 1, dict, digits);
            state.deleteCharAt(state.length() - 1);
        }
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.letterCombinations("23"));
        System.out.println(s.letterCombinations(""));
        System.out.println(s.letterCombinations("4673"));
    }
}
