package com.catxu.leetcode.question443;

/**
 * 443. String Compression
 */
class Solution {
    public int compress(char[] cs) {
        int n = cs.length;
        // 快指针对重复计数
        int s = 0, f = 0;
        while (f < n) {
            int j = f;
            while (j < n && cs[f] == cs[j]) j++;
            int cnt = j - f; // 重复数量
            cs[s] = cs[f]; // 重置下一个待压缩字符
            int i = s;
            if (cnt > 1) {
                while (cnt != 0) {
                    cs[++i] = (char) (cnt % 10 + '0');
                    cnt /= 10;
                }
                // 翻转数字
                reverse(cs, s + 1, i);
            }
            s = i + 1;
            f = j; // 向后移动快指针进行下一个字符计数
        }
        return s;
    }

    private void reverse(char[] cs, int l, int r) {
        while (l < r) {
            char c = cs[l];
            cs[l] = cs[r];
            cs[r] = c;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
        System.out.println(new Solution().compress(new char[]{'a'}));
        System.out.println(new Solution().compress(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'c', 'c'}));
        System.out.println(new Solution().compress(new char[]{'b', 'b', 'b', 'c'}));
    }
}