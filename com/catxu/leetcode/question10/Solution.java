package com.catxu.leetcode.question10;

/**
 * 10. Regular Expression Matching
 * <p>
 * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
 * <p>
 * '.' Matches any single character.
 * <p>
 * '*' Matches zero or more of the preceding element.
 * <p>
 * The matching should cover the entire input string (not partial).
 * <p>
 * Example 1:
 * <pre>
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * </pre>
 * Example 2:
 * <pre>
 * Input: s = "aa", p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * </pre>
 * Example 3:
 * <pre>
 * Input: s = "ab", p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * </pre>
 * Constraints:
 * <pre>
 * 1 <= s.length <= 20
 * 1 <= p.length <= 20
 * s contains only lowercase English letters.
 * p contains only lowercase English letters, '.', and '*'.
 * It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
 * </pre>
 */
class Solution {
    private char[] s;
    private char[] p;

    private Boolean[][] memo;

    public boolean isMatch(String s, String p) {
        this.s = s.toCharArray();
        this.p = p.toCharArray();
        this.memo = new Boolean[s.length() + 1][p.length() + 1];
        return dfs(0, 0);
    }

    private boolean dfs(int i, int j) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        if (i == s.length && j == p.length) {
            return true;
        } else if (j == p.length) {
            return false;
        }
        boolean match = i < s.length && (p[j] == '.' || p[j] == s[i]);
        if (j + 1 < p.length && p[j + 1] == '*') { // 【贪心】优先校验 [j+1] 是否为 '*'
            if (!match) {
                /* '*' 匹配 0 次 */
                match = dfs(i, j + 2);
            } else {
                /* Use the '*' 使用 '*' 的前提是前值必须match */
                match = dfs(i, j + 2) || dfs(i + 1, j);
            }
            memo[i][j] = match;
            return match;
        } else if (match) {
            memo[i][j] = match;
            return dfs(i + 1, j + 1);
        }
        memo[i][j] = match;
        return memo[i][j];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("ab", ".*"));
        System.out.println(solution.isMatch("ab", ".*c"));
        System.out.println(solution.isMatch("abb", ".*abb"));
//        System.out.println(solution.isMatch("aab", "c*a*a*b*"));
//        System.out.println(solution.isMatch("ab", ".*..."));
//        System.out.println(solution.isMatch("aaaaaaaaaaaaaaaaaaaac", "a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*"));
    }
}
