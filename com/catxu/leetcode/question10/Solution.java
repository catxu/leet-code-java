package com.catxu.leetcode.question10;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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
 * <p>
 * Input: s = "aa", p = "a"
 * <p>
 * Output: false
 * <p>
 * Explanation: "a" does not match the entire string "aa".
 * <p>
 * Example 2:
 * <p>
 * Input: s = "aa", p = "a*"
 * <p>
 * Output: true
 * <p>
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * <p>
 * Example 3:
 * <p>
 * Input: s = "ab", p = ".*"
 * <p>
 * Output: true
 * <p>
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 20
 * <p>
 * 1 <= p.length <= 20
 * <p>
 * s contains only lowercase English letters.
 * <p>
 * p contains only lowercase English letters, '.', and '*'.
 * <p>
 * It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
 */
class Solution {
    private char[] s;
    private char[] p;

    private Map<Memoizer, Boolean> cache;

    public boolean isMatch(String s, String p) {
        this.s = s.toCharArray();
        this.p = p.toCharArray();
        cache = new HashMap<>(this.s.length + this.p.length);
        return dfs(0, 0);
    }

    private boolean dfs(int i, int j) {
        Memoizer memoizer = Memoizer.of(i, j);
        if (cache.containsKey(memoizer)) {
            return cache.get(memoizer);
        }
        if (i >= s.length && j >= p.length) {
            return true;
        }
        if (j >= p.length) {
            return false;
        }
        // [i] maybe out of bound
        boolean match = i < s.length && (s[i] == p[j] || p[j] == '.');
        if (j + 1 < p.length && p[j + 1] == '*') {
            // decision tree
            cache.put(memoizer, dfs(i, j + 2) /* Dont use '*' */ || (match && dfs(i + 1, j))/* Use the '*' */);
            return cache.get(memoizer);
        }
        if (match) {
            cache.put(memoizer, dfs(i + 1, j + 1));
            return cache.get(memoizer);
        }
        cache.put(memoizer, false);
        return false;
    }

    static class Memoizer {
        private int i;
        private int j;

        public Memoizer(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public static Memoizer of(int i, int j) {
            return new Memoizer(i, j);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Memoizer) {
                return ((Memoizer) obj).i == this.i && ((Memoizer) obj).j == this.j;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(i) ^ Objects.hashCode(j);
        }
    }

    public static void main(String[] args) {
//        System.out.println(Objects.hash(0));
//        System.out.println(Objects.hash(1));
//        System.out.println(Objects.hash(1) ^ Objects.hash(0));
        Solution solution = new Solution();
        System.out.println(solution.isMatch("ab", ".*"));
        System.out.println(solution.isMatch("ab", ".*c"));
//        System.out.println(solution.isMatch("abb", ".*abb"));
//        System.out.println(solution.isMatch("aab", "c*a*a*b*"));
//        System.out.println(solution.isMatch("ab", ".*..."));
//        System.out.println(solution.isMatch("aaaaaaaaaaaaaaaaaaaac", "a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*"));
    }
}
