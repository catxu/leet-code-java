package com.catxu.leetcode.question5;

/**
 * 5. Longest Palindromic Substring
 * <p>
 * Given a string s, return the longest
 * palindromic
 * <p>
 * substring
 * in s.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: s = "cbbd"
 * Output: "bb"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */
class Solution {
    public static String longestPalindrome(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        int maxLen = 1;
        int begin = 0;
        for (int i = 0; i < length - 1; i++) {
            int oddLen = expendAroundCenter(chars, i, i);
            int evenLen = expendAroundCenter(chars, i, i + 1);
            int currentMax = Math.max(oddLen, evenLen);
            if (currentMax > maxLen) {
                maxLen = currentMax;
                begin = i - (maxLen - 1) / 2;
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    private static int expendAroundCenter(char[] chars, int left, int right) {
        int len = chars.length;
        while (left >= 0 && right < len) {
            if (chars[left] == chars[right]) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aba"));
    }
}