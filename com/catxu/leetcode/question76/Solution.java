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

    //    private String minWindow = "";
//    private int minLength = Integer.MAX_VALUE;
//    private int tSize;
//
//    public String minWindow(String s, String t) {
//        if (t.isEmpty() || s.length() < t.length()) {
//            return "";
//        }
//        tSize = t.length();
//        // Frequency map for the target string
//        Map<Character, Integer> targetMap = new HashMap<>();
//        for (char c : t.toCharArray()) {
//            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
//        }
//
//        // Start backtracking
//        backtrack(s, targetMap, new StringBuilder(), 0);
//        return minWindow;
//    }
//
//    private void backtrack(String s, Map<Character, Integer> targetMap, StringBuilder current, int index) {
//        if (index > s.length()) {
//            return;
//        }
//
//        // Check if the current substring is valid
//        if (current.length() >= tSize && containsAllCharacters(current.toString(), targetMap)) {
//            if (current.length() < minLength) {
//                minLength = current.length();
//                minWindow = current.toString();
//            }
//        }
//
//        // Explore further substrings
//        for (int i = index; i < s.length(); i++) {
//            current.append(s.charAt(i)); // Add current character
//            backtrack(s, targetMap, current, i + 1); // Recursive call
//            current.deleteCharAt(current.length() - 1); // Backtrack
//        }
//    }
//
//    private boolean containsAllCharacters(String str, Map<Character, Integer> targetMap) {
//        Map<Character, Integer> countMap = new HashMap<>();
//        for (char c : str.toCharArray()) {
//            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
//        }
//
//        for (Map.Entry<Character, Integer> entry : targetMap.entrySet()) {
//            char key = entry.getKey();
//            int value = entry.getValue();
//            if (countMap.getOrDefault(key, 0) < value) {
//                return false;
//            }
//        }
//        return true;
//    }
//
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minWindow("ADOBECODEBANC", "ABC"));
//        System.out.println(s.minWindow("a", "a"));
//        System.out.println(s.minWindow("a", "aa"));
    }

    public String minWindow(String s, String t) {
        if (t.isEmpty() || t.length() > s.length()) {
            return "";
        }
        Map<Character, Integer> targetMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }
        dfs(s, targetMap, t.length(), 0, new StringBuilder());
        return ans;
    }

    String ans = "";
    int minWindow = Integer.MAX_VALUE;

    private void dfs(String s,
                     Map<Character, Integer> targetMap,
                     int minSize,
                     int startIndex,
                     StringBuilder state) {
        if (startIndex > s.length()) {
            return;
        }
        if (state.length() >= minSize && state.length() < minWindow && containsAll(state.toString(), targetMap)) {
            minWindow = state.length();
            ans = state.toString();
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            state.append(s.charAt(i));
            dfs(s, targetMap, minSize, i + 1, state);
            state.deleteCharAt(state.length() - 1);
        }

    }

    private boolean containsAll(String current, Map<Character, Integer> targetMap) {
        Map<Character, Integer> currentMap = new HashMap<>();
        for (int i = 0; i < current.length(); i++) {
            char c = current.charAt(i);
            currentMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : targetMap.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (currentMap.getOrDefault(key, 0) - value < 0) {
                return false;
            }
        }
        return true;
    }
}
