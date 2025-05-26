package com.catxu.leetcode.question383;

import java.util.HashMap;
import java.util.Map;

/**
 * 383. Ransom Note
 * <p>
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 * <p>
 * Each letter in magazine can only be used once in ransomNote.
 * <p>
 * Example 1:
 * <pre>
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * </pre>
 * Example 2:
 * <pre>
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * </pre>
 * Example 3:
 * <pre>
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 * </pre>
 * Constraints:
 * <pre>
 * 1 <= ransomNote.length, magazine.length <= 10<sup>5</sup>
 * ransomNote and magazine consist of lowercase English letters.
 * </pre>
 */
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        for (char c : ransomNote.toCharArray()) {
            int update = countMap.getOrDefault(c, 0) - 1;
            if (update < 0) {
                return false;
            }
            countMap.put(c, update);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canConstruct("a", "b"));
        System.out.println(new Solution().canConstruct("aa", "ab"));
        System.out.println(new Solution().canConstruct("aa", "aab"));
    }
}
