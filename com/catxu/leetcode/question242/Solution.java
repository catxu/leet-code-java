package com.catxu.leetcode.question242;

import java.util.HashMap;
import java.util.Map;

/**
 * 242. Valid Anagram
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> dict = new HashMap<>();
        for (char c : s.toCharArray()) {
            dict.merge(c, 1, Integer::sum);
        }
        for (char c : t.toCharArray()) {
            if (!dict.containsKey(c)) {
                return false;
            } else if (dict.get(c) > 1) {
                dict.merge(c, -1, Integer::sum);
            } else {
                dict.remove(c);
            }
        }
        return dict.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isAnagram("anagram", "nagaram"));
        System.out.println(new Solution().isAnagram("rat", "car"));
    }
}