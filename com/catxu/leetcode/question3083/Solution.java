package com.catxu.leetcode.question3083;

/**
 * 3083. Existence of a Substring in a String and Its Reverse
 */
class Solution {
    public boolean isSubstringPresent(String s) {
        char[] str = s.toCharArray();
        boolean[][] res = new boolean[26][26];
        for (int i = 1; i < str.length; i++) {
            int x = str[i - 1] - 'a';
            int y = str[i] - 'a';
            res[x][y] = true;
            if (res[y][x]) {
                return true;
            }
        }
        return false;
    }
    /* "abcba": "ab","bc","cb","ba"
    *
    *        [a],[b],[c]
    *        [0],[1],[2]
    * [a][0] [],[true],[]     [],["ba"],[]
    * [b][1] [true],[],[true] ["ab"],[],["cb"]
    * [c][2] [],[true],[]     [],["bc"],[]
    *
    * */

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isSubstringPresent("leetcode"));
        System.out.println(s.isSubstringPresent("abcba"));
        System.out.println(s.isSubstringPresent("abcd"));
    }
}