package com.catxu.leetcode.question3297;

import java.util.HashMap;
import java.util.Map;

/**
 * 3297. Count Substrings That Can Be Rearranged to Contain a String I
 * <p>
 * You are given two strings word1 and word2.
 * <p>
 * A string x is called valid if x can be rearranged to have word2 as a prefix.
 * <p>
 * Return the total number of valid substrings of word1.
 * <p>
 * Example 1:
 * <p>
 * Input: word1 = "bcca", word2 = "abc"
 * <p>
 * Output: 1
 * <p>
 * Explanation:
 * <p>
 * The only valid substring is "bcca" which can be rearranged to "abcc" having "abc" as a prefix.
 * <p>
 * Example 2:
 * <p>
 * Input: word1 = "abcabc", word2 = "abc"
 * <p>
 * Output: 10
 * <p>
 * Explanation:
 * <p>
 * All the substrings except substrings of size 1 and size 2 are valid.
 * <p>
 * Example 3:
 * <p>
 * Input: word1 = "abcabc", word2 = "aaabc"
 * <p>
 * Output: 0
 * <p>
 * Constraints:
 * <p>
 * 1 <= word1.length <= 10<sup>5</sup>
 * <p>
 * 1 <= word2.length <= 10<sup>4</sup>
 * <p>
 * word1 and word2 consist only of lowercase English letters.
 */
class Solution {
    public long validSubstringCount(String word1, String word2) {
        if (word1.length() < word2.length()) {
            return 0;
        }
        Map<Character, Integer> target = new HashMap<>();
        for (char c : word2.toCharArray()) {
            target.merge(c, 1, Integer::sum);
        }
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0, valid = 0;
        long ans = 0L;
        while (right < word1.length()) {
            char c = word1.charAt(right);
            if (target.containsKey(c)) {
                window.merge(c, 1, Integer::sum);
                if (target.get(c).equals(window.get(c))) {
                    valid++;
                }
            }
            while (valid == target.size()) {
                char d = word1.charAt(left);
                left++;
                if (target.containsKey(d)) {
                    if (window.merge(d, -1, Integer::sum) < target.get(d)) {
                        valid--;
                    }
                }
            }
            // 注意 answer 在循环外添加，找到一次后 left++，后续都可以通过 rearrange 组成 前缀为 word2 的 substring
            ans += left;
            right++;
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().validSubstringCount("dcbdcdccb", "cdd"));

        System.out.println(new Solution().validSubstringCount("bcca", "abc"));
        System.out.println(new Solution().validSubstringCount("abcabc", "abc"));
        System.out.println(new Solution().validSubstringCount("abcabc", "aaabc"));
    }
}
