package com.catxu.leetcode.question680;

/**
 * 680. Valid Palindrome II
 */
class Solution {
    public boolean validPalindrome(String s) {
        return isPalindrome(s, 0, s.length() - 1, 1);
    }

    private boolean isPalindrome(String s, int left, int right, int remainingDeletes) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (remainingDeletes == 0) return false;
                // Try removing either left or right character
                return isPalindrome(s, left + 1, right, remainingDeletes - 1) ||
                        isPalindrome(s, left, right - 1, remainingDeletes - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
        System.out.println(new Solution().validPalindrome("abca"));
        System.out.println(new Solution().validPalindrome("abc"));
        System.out.println(new Solution().validPalindrome("accaa"));
        System.out.println(new Solution().validPalindrome("a"));
    }
}
