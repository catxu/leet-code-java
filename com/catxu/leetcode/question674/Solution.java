package com.catxu.leetcode.question674;

/**
 * 674. Longest Continuous Increasing Subsequence
 */
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int ans = 1, n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            if (i > 0 && nums[i] > nums[i - 1]) {
                // 以 i 结尾最长且连续递增的子序列长度
                dp[i] = dp[i - 1] + 1;
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(new Solution().findLengthOfLCIS(new int[]{1, 1, 1, 1, 1}));
    }

}