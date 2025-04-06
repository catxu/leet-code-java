package com.catxu.leetcode.question97;

/**
 * 97. Interleaving String
 */
class Solution {
    private int[][][] dp;

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        if (s1.isEmpty()) {
            return s2.equals(s3);
        } else if (s2.isEmpty()) {
            return s1.equals(s3);
        }
        dp = new int[s1.length() + 1][s2.length() + 1][3];
        return dfs(s1, 0, s2, -1, s3, 1) || dfs(s1, -1, s2, 0, s3, 2);
    }

    private boolean dfs(String s1, int i, String s2, int j, String s3, int curBeginWithS) {
        if ((curBeginWithS == 1 && i > s1.length() - 1)
                || (curBeginWithS == 2 && j > s2.length() - 1)) {
            return false;
        }
        if (dp[i + 1][j + 1][curBeginWithS] != 0) {
            return dp[i + 1][j + 1][curBeginWithS] == 1;
        }
        char c1, c2, c3;
        c3 = s3.charAt(i + j + 1);
        if (curBeginWithS == 1) {
            c1 = s1.charAt(i);
            if (c1 != c3) {
                dp[i + 1][j + 1][curBeginWithS] = -1;
                return false;
            } else if (i + j + 2 == s3.length()) {
                dp[i + 1][j + 1][curBeginWithS] = 1;
                return true;
            } else {
                boolean res = dfs(s1, i + 1, s2, j, s3, curBeginWithS) || dfs(s1, i, s2, j + 1, s3, curBeginWithS + 1);
                dp[i + 1][j + 1][curBeginWithS] = res ? 1 : -1;
                return res;
            }
        } else {
            c2 = s2.charAt(j);
            if (c2 != c3) {
                dp[i + 1][j + 1][curBeginWithS] = -1;
                return false;
            } else if (i + j + 2 == s3.length()) {
                dp[i + 1][j + 1][curBeginWithS] = 1;
                return true;
            } else {
                boolean res = dfs(s1, i, s2, j + 1, s3, curBeginWithS) || dfs(s1, i + 1, s2, j, s3, curBeginWithS - 1);
                dp[i + 1][j + 1][curBeginWithS] = res ? 1 : -1;
                return res;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isInterleave("b", "a", "ab"));
        System.out.println(new Solution().isInterleave("aa", "ab", "abaa"));
        System.out.println(new Solution().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(new Solution().isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }
}
