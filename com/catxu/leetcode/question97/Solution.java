package com.catxu.leetcode.question97;

/**
 * 97. Interleaving String
 */
class Solution {

    private Boolean[][] memo;
    private int m, n, l;

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        m = s1.length();
        n = s2.length();
        l = s3.length();
        memo = new Boolean[m + 1][n + 1];
        return dfs(s1, 0, s2, 0, s3);
    }

    private boolean dfs(String s1, int i, String s2, int j, String s3) {
        if (i + j == l) {
            return true;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        boolean res = false;
        char cur = s3.charAt(i + j);
        // i 达到 m 后会继续匹配后续的 j （如果还有的话）
        if (i < m && s1.charAt(i) == cur) {
            res |= dfs(s1, i + 1, s2, j, s3);
        }
        // j 达到 n 后会继续匹配后续的 i （如果还有的话）
        if (j < n && s2.charAt(j) == cur) {
            res |= dfs(s1, i, s2, j + 1, s3);
        }
        memo[i][j] = res;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isInterleave("b", "a", "ab"));
        System.out.println(new Solution().isInterleave("aa", "ab", "abaa"));
        System.out.println(new Solution().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(new Solution().isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }
}
