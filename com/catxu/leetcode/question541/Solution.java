package com.catxu.leetcode.question541;

/**
 * 541. Reverse String II
 */
class Solution {
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] chs = s.toCharArray();
        for (int l = 0; l < n; l += 2 * k) {
            int r = l + k - 1;
            reverse(chs, l, Math.min(r, n - 1));
        }
        return new String(chs);
    }

    private void reverse(char[] s, int l, int r) {
        while (l < r) {
            char t = s[l];
            s[l] = s[r];
            s[r] = t;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseStr("abcd", 2));
    }
}
