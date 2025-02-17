package com.catxu.leetcode.question151;

/**
 * 151. Reverse Word in a String
 */
class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder res = new StringBuilder();
        int l = s.length() - 1, r = l;
        while (l >= 0) {
            while (l >= 0 && s.charAt(l) != ' ') {
                l--;
            }
            res.append(s, l + 1, r + 1).append(" ");
            while (l >= 0 && s.charAt(l) == ' ') {
                l--;
            }
            r = l;
        }
        return res.toString().trim();
    }


    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("the sky is blue"));
        System.out.println(new Solution().reverseWords("  hello world  "));
        System.out.println(new Solution().reverseWords("a good   example"));
    }
}
