package com.catxu.leetcode.question796;

/**
 * 796. Rotate String
 */
class Solution {
    public boolean rotateString(String s, String goal) {
        int len;
        if ((len = s.length()) != goal.length()) {
            return false;
        }
        if (s.equals(goal)) {
            return true;
        }
        for (int i = 1; i < len; i++) {
            s = s.substring(1) + s.charAt(0);
            if (s.equals(goal)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.rotateString("abcde", "abcde"));
        System.out.println(s.rotateString("abcde", "bcdae"));
    }
}