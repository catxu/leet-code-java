package com.catxu.leetcode.question3;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. Longest Substring Without Repeating Characters
 * <p>
 * Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcabcbb"
 * <p>
 * Output: 3
 * <p>
 * Explanation: The answer is "abc", with the length of 3.
 * <p>
 * Example 2:
 * <p>
 * Input: s = "bbbbb"
 * <p>
 * Output: 1
 * <p>
 * Explanation: The answer is "b", with the length of 1.
 * <p>
 * Example 3:
 * <p>
 * Input: s = "pwwkew"
 * <p>
 * Output: 3
 * <p>
 * Explanation: The answer is "wke", with the length of 3.
 * <p>
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * <p>
 * Constraints:
 * <p>
 * 0 <= s.length <= 5 * 10<sup>4</sup>
 * <p>
 * s consists of English letters, digits, symbols and spaces.
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = 0, begin = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0; end < s.length(); end++) {
            if (map.containsKey(s.charAt(end))) {
                // 这一步保证了子串最大回溯不包含重复子串
                // 如果写成 begin = map.get(s.charAt(end)) + 1
                // 在类似于 "abba" 的字符结构中，对 s.charAt(3) 即第二个 'a' 进行回溯时，子串会包含 'bba'，不符合题目要求
                begin = Math.max(map.get(s.charAt(end)) + 1, begin);
            }
            len = Math.max(len, end - begin + 1);
            map.put(s.charAt(end), end);
        }
        return len;
    }

}


