package com.catxu.leetcode.question2275;

/**
 * 2275. Largest Combination With Bitwise AND Greater Than Zero
 */
class Solution {
    public int largestCombination(int[] candidates) {
        int n = candidates.length, m = Integer.toBinaryString(10_000000).length();
        int[][] mat = new int[n][m];
        for (int i = 0; i < n; i++) {
            String binary = Integer.toBinaryString(candidates[i]);
            // 从 mat[i] 的末尾开始填充
            int len = binary.length();
            for (int j = 0; j < len; j++) {
                mat[i][m - 1 - j] = binary.charAt(len - 1 - j) - '0';
            }
        }
        int ans = 0;
        for (int j = 0; j < m; j++) {
            int result = 0;
            for (int i = 0; i < n; i++) {
                // 判断每一列 '1' 的个数
                result += mat[i][j];
            }
            ans = Math.max(ans, result);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largestCombination(new int[]{16,17,71,62,12,24,14}));
        System.out.println(new Solution().largestCombination(new int[]{8,8}));
    }
}
