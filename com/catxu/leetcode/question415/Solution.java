package com.catxu.leetcode.question415;

/**
 * 415. Add Strings
 */
class Solution {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        char[] s1 = num1.toCharArray();
        char[] s2 = num2.toCharArray();
        StringBuilder ans = new StringBuilder();
        int carry = 0;
        for (int i = len1 - 1, j = len2 - 1; i >= 0 || j >= 0; i--, j--) {
            int n1 = i < 0 ? 0 : s1[i] - '0';
            int n2 = j < 0 ? 0 : s2[j] - '0';
            int sum = n1 + n2 + carry;
            ans.insert(0, sum % 10);
            carry = sum / 10;
        }
        if (carry != 0) {
            ans.insert(0, carry);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addStrings("123", "456"));
        System.out.println(new Solution().addStrings("123", "77"));
        System.out.println(new Solution().addStrings("1", "9"));
    }
}