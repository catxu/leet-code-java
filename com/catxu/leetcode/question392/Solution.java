package com.catxu.leetcode.question392;

/**
 * 392. Is Subsequence
 * <p>
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 * <p>
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abc", t = "ahbgdc"
 * <p>
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: s = "axc", t = "ahbgdc"
 * <p>
 * Output: false
 * <p>
 * Constraints:
 * <p>
 * 0 <= s.length <= 100
 * <p>
 * 0 <= t.length <= 10<sup>4</sup>
 * <p>
 * s and t consist only of lowercase English letters.
 * <p>
 * Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?
 */
class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isSubsequence("abc", "ahbgdc"));
        System.out.println(s.isSubsequence("axc", "ahbgdc"));
    }
}
