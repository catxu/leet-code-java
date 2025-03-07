package com.catxu.leetcode.question1328;

/**
 * 1328. Break a Palindrome
 */
class Solution {
    public String breakPalindrome(String palindrome) {
        int len = palindrome.length();
        if (len <= 1)
            return "";
        char[] s = palindrome.toCharArray();
        for (int i = 0; i < len / 2; i++) {
            if (s[i] != 'a') {
                s[i] = 'a';
                return new String(s);
            }
        }
        s[len - 1] = 'b';
        return new String(s);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().breakPalindrome("abccba"));
        System.out.println(new Solution().breakPalindrome("a"));
        System.out.println(new Solution().breakPalindrome("aa"));
        System.out.println(new Solution().breakPalindrome("aca"));
    }
}
