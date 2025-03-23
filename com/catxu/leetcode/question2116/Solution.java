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
        // low表示最坏情况下（即'0'全当')'）剩余未配对的左括号
        // high表示最好情况下（即'0'全当'('）剩余未配对的左括号
        // high任何时候都不能小于0，因为在有效括号字符串的任意一个前缀中，左括号的数量都大于等于右括号的数量
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
