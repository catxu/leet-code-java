package com.catxu.leetcode.question76;

import java.util.*;

/**
 * 76. Minimum Window Substring
 * <p>
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 * <p>
 * The testcases will be generated such that the answer is unique.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * <p>
 * Output: "BANC"
 * <p>
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * <p>
 * Example 2:
 * <p>
 * Input: s = "a", t = "a"
 * <p>
 * Output: "a"
 * <p>
 * Explanation: The entire string s is the minimum window.
 * <p>
 * Example 3:
 * <p>
 * Input: s = "a", t = "aa"
 * <p>
 * Output: ""
 * <p>
 * Explanation: Both 'a's from t must be included in the window. Since the largest window of s only has one 'a', return empty string.
 * <p>
 * Constraints:
 * <p>
 * m == s.length
 * <p>
 * n == t.length
 * <p>
 * 1 <= m, n <= 10<sup>5</sup>
 * <p>
 * s and t consist of uppercase and lowercase English letters.
 * <p>
 * Follow up: Could you find an algorithm that runs in O(m + n) time?
 */
class Solution {

    private String minWindow = "";
    private int minLength = Integer.MAX_VALUE;
    private int minSize;
    private Set<String> memo;

    public String minWindow(String s, String t) {
        if (t.isEmpty() || s.length() < t.length()) {
            return "";
        }

        this.minSize = t.length();
        this.memo = new HashSet<>();
        // Frequency map for the target string
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        // Start backtracking
        backtrack(s, targetMap, 0, 0);
        return minWindow;
    }

    private void backtrack(String s, Map<Character, Integer> targetMap, int start, int end) {
        if (start > s.length()) {
            return;
        }
        // Generate a key for memoization
        String memoKey = start + "," + end;
        if (memo.contains(memoKey)) {
            return;
        }
        // Check if the current substring is valid
        int currentLength = end - start;
        if (start < end
                && currentLength >= minSize
                && currentLength < minLength
                && targetMap.containsKey(s.charAt(start))
                && targetMap.containsKey(s.charAt(end - 1))
                && containsAllCharacters(s.substring(start, end), targetMap)) {
            minLength = currentLength;
            minWindow = s.substring(start, end);
        }

        // Explore extending the substring by advancing `end`
        if (end < s.length()) {
            backtrack(s, targetMap, start, end + 1);
        }

        // Explore moving the `start` pointer forward (shrinking the substring)
        if (start < end) {
            backtrack(s, targetMap, start + 1, end);
        }

        // Store the result in the memoization set
        memo.add(memoKey);
    }

    private boolean containsAllCharacters(String str, Map<Character, Integer> targetMap) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : targetMap.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            if (countMap.getOrDefault(key, 0) < value) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(new Solution().minWindow("a", "a"));
        System.out.println(new Solution().minWindow("a", "aa"));
        System.out.println(new Solution().minWindow("BCA", "C"));
    }

}
