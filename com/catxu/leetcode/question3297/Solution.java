package com.catxu.leetcode.question3297;

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
        return -1L;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().validSubstringCount("abcc", "abc"));
        System.out.println(new Solution().validSubstringCount("abcabc", "abc"));
    }
}
