package com.catxu.leetcode.question3;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. Longest Substring Without Repeating Characters
 * <p>
 * Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <pre>
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * </pre>
 * Example 2:
 * <pre>
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * </pre>
 * Example 3:
 * <pre>
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * </pre>
 * <p>
 * Constraints:
 * <pre>
 * 0 <= s.length <= 5 * 10<sup>4</sup>
 * s consists of English letters, digits, symbols and spaces.
 * </pre>
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = 0, begin = 0;
        Set<Character> window = new HashSet<>();
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            while (window.contains(ch)) {
                window.remove(s.charAt(begin++));
            }
            window.add(ch);
            len = Math.max(len, window.size());
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new Solution().lengthOfLongestSubstring("abbac"));
    }

}


