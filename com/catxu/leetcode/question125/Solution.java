package com.catxu.leetcode.question125;

/**
 * 125. Valid Palindrome
 * <p>
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 * <p>
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "A man, a plan, a canal: Panama"
 * <p>
 * Output: true
 * <p>
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * <p>
 * Example 2:
 * <p>
 * Input: s = "race a car"
 * <p>
 * Output: false
 * <p>
 * Explanation: "raceacar" is not a palindrome.
 * <p>
 * Example 3:
 * <p>
 * Input: s = " "
 * <p>
 * Output: true
 * <p>
 * Explanation: s is an empty string "" after removing non-alphanumeric characters. Since an empty string reads the same forward and backward, it is a palindrome.
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 2 * 10<sup>5</sup>
 * <p>
 * s consists only of printable ASCII characters.
 */
class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            char l = s.charAt(i);
            char r = s.charAt(j);
            if (!Character.isLetterOrDigit(l)) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(r)) {
                j--;
                continue;
            }
            if (Character.toLowerCase(l) != Character.toLowerCase(r)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(s.isPalindrome("race a car"));
        System.out.println(s.isPalindrome(" "));
        System.out.println(s.isPalindrome(""));
        System.out.println(s.isPalindrome("0P"));
    }
}
