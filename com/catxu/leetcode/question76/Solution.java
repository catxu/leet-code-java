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
 * <pre>
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * </pre>
 * Example 2:
 * <pre>
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * </pre>
 * Example 3:
 * <pre>
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window. Since the largest window of s only has one 'a', return empty string.
 * </pre>
 * Constraints:
 * <pre>
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 10<sup>5</sup>
 * s and t consist of uppercase and lowercase English letters.
 * </pre>
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
            targetMap.merge(c, 1, Integer::sum);
        }

        // 窗口内字符频率
        Map<Character, Integer> windowMap = new HashMap<>();
        int left = 0, right = 0; // 左右指针
        int valid = 0; // 有效匹配字符数
        int start = 0, minLength = Integer.MAX_VALUE;

        while (right < s.length()) {
            char c = s.charAt(right++);

            // windowMap.merge(c, 1, Integer::sum);
            // 更新窗口内字符频率
            if (targetMap.containsKey(c)) {
                int cnt = windowMap.merge(c, 1, Integer::sum); // 有效字符才更新窗口，能有效减少put操作频率
                if (cnt == targetMap.get(c)) {
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

                char d = s.charAt(left++);

                if (targetMap.containsKey(d)) {
                    if (windowMap.get(d).equals(targetMap.get(d))) {
                        valid--;
                    }
                    windowMap.merge(d, -1, Integer::sum);
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
