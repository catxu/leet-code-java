package com.catxu.leetcode.question2116;

/**
 * 2116. Check if a Parentheses String Can Be Valid
 */
class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n % 2 != 0) {
            return false;
        }
        int low = 0, high = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i), l = locked.charAt(i);
            if (l == '0') {
                low--;
                high++;
            } else if (c == '(') {
                low++;
                high++;
            } else {
                if (high == 0) {
                    return false;
                }
                low--;
                high--;
            }
            low = Math.max(low, 0);
        }
        return low == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canBeValid("))()))", "010100"));
        System.out.println(new Solution().canBeValid("()()", "0000"));
        System.out.println(new Solution().canBeValid(")", "0"));
    }
}
