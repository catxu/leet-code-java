package com.catxu.leetcode.question10;

/**
 * 10. Regular Expression Matching
 * <p>
 * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
 * <p>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 * <p>
 * Input: s = "aa", p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * Example 3:
 * <p>
 * Input: s = "ab", p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 20
 * 1 <= p.length <= 20
 * s contains only lowercase English letters.
 * p contains only lowercase English letters, '.', and '*'.
 * It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
 */
class Solution {
    private char[] s;
    private char[] p;

    public boolean isMatch(String s, String p) {
        this.s = s.toCharArray();
        this.p = p.toCharArray();
        return dfs(0, 0);
    }

    private boolean dfs(int i, int j) {
        if (i >= s.length && j >= p.length) {
            return true;
        }
        if (j >= p.length) {
            return false;
        }
        boolean match = i < s.length && (s[i] == p[j] || p[j] == '.');
        if (j + 1 < p.length && p[j + 1] == '*') {
            return dfs(i, j + 2) || (match && dfs(i + 1, j));
        }
        if (match) {
            return dfs(i + 1, j + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.isMatch("ab", ".*"));
//        System.out.println(solution.isMatch("abb", ".*abb"));
        System.out.println(solution.isMatch("aab", "c*a*a*b*"));
    }
}
