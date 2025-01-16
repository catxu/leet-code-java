package com.catxu.leetcode.question290;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. Word Pattern
 * <p>
 * Given a pattern and a string s, find if s follows the same pattern.
 * <p>
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s. Specifically:
 * <p>
 * Each letter in pattern maps to exactly one unique word in s.
 * <p>
 * Each unique word in s maps to exactly one letter in pattern.
 * <p>
 * No two letters map to the same word, and no two words map to the same letter.
 * <p>
 * Example 1:
 * <pre>
 * Input: pattern = "abba", s = "dog cat cat dog"
 * Output: true
 * Explanation:
 * The bijection can be established as:
 * 'a' maps to "dog".
 * 'b' maps to "cat".
 * </pre>
 * Example 2:
 * <pre>
 * Input: pattern = "abba", s = "dog cat cat fish"
 * Output: false
 * </pre>
 * Example 3:
 * <pre>
 * Input: pattern = "aaaa", s = "dog cat cat dog"
 * Output: false
 * </pre>
 * Constraints:
 * <pre>
 * 1 <= pattern.length <= 300
 * pattern contains only lower-case English letters.
 * 1 <= s.length <= 3000
 * s contains only lowercase English letters and spaces ' '.
 * s does not contain any leading or trailing spaces.
 * All the words in s are separated by a single space.
 * </pre>
 */
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split("\\s+");
        if (words.length != pattern.length()) {
            return false;
        }
        Map<Character, String> s2tMap = new HashMap<>();
        Map<String, Character> t2sMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = words[i];
            if (s2tMap.containsKey(ch) && !s2tMap.get(ch).equals(word) ||
                    t2sMap.containsKey(word) && !t2sMap.get(word).equals(ch)) {
                return false;
            }
            s2tMap.put(ch, word);
            t2sMap.put(word, ch);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().wordPattern("abba", "cat dog dog cat"));
        System.out.println(new Solution().wordPattern("abba", "cat dog dog fish"));
        System.out.println(new Solution().wordPattern("aaaa", "cat dog dog cat"));
        System.out.println(new Solution().wordPattern("a", "cat"));
        System.out.println(new Solution().wordPattern("a", "Cat"));
        System.out.println(new Solution().wordPattern("a", "a"));
    }
}
