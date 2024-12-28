package com.catxu.leetcode.question76;

import java.util.HashMap;
import java.util.Map;

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

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        // 记录目标字符频率
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        // 窗口内字符频率
        Map<Character, Integer> windowMap = new HashMap<>();
        int left = 0, right = 0; // 左右指针
        int valid = 0; // 有效匹配字符数
        int minLength = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            // 更新窗口内字符频率
            if (targetMap.containsKey(c)) {
                windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
                if (windowMap.get(c).equals(targetMap.get(c))) {
                    valid++;
                }
            }

            // 当窗口符合条件时，收缩左边界
            while (valid == targetMap.size()) {
                // 更新最小窗口
                if (right - left < minLength) {
                    minLength = right - left;
                    start = left;
                }

                char d = s.charAt(left);
                left++;

                if (targetMap.containsKey(d)) {
                    if (windowMap.get(d).equals(targetMap.get(d))) {
                        valid--;
                    }
                    windowMap.put(d, windowMap.get(d) - 1);
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }


    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(new Solution().minWindow("a", "a"));
        System.out.println(new Solution().minWindow("a", "aa"));
        System.out.println(new Solution().minWindow("BCA", "C"));
    }

}
