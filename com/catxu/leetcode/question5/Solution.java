package com.catxu.leetcode.question5;

/**
 * 5. Longest Palindromic Substring
 * <p>
 * Given a string s, return the longest palindromic substring in s.
 * <p>
 * Example 1:
 * <pre>
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * </pre>
 * Example 2:
 * <pre>
 * Input: s = "cbbd"
 * Output: "bb"
 * Constraints:
 * </pre>
 * <pre>
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 * </pre>
 */
class Solution {
    public static String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        int maxLen = 1, begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        // 枚举子串长度
        for (int len = 2; len <= n; len++) {
            // 枚举左边界
            for (int i = 0; i < n - 1; i++) {
                // 右边界
                int j = i + len - 1;
                if (j - i >= len) { // 超过窗口长度
                    break;
                }
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) { // j 和 i 之间只有1个字符或没有字符
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && len > maxLen) {
                    maxLen = len;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /*public static String longestPalindrome(String s) {
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
    }*/

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