package com.catxu.leetcode.question53;

/**
 * 53. Maximum Subarray
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int ans = dp[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    /*
     * 递推版本
     */
    public int maxSubArrayRecursive(int[] nums) {
        int ans = nums[0], prevMaxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prevMaxSum = Math.max(nums[i], nums[i] + prevMaxSum);
            ans = Math.max(ans, prevMaxSum);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(new Solution().maxSubArrayRecursive(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(new Solution().maxSubArray(new int[]{1}));
        System.out.println(new Solution().maxSubArrayRecursive(new int[]{1}));
        System.out.println(new Solution().maxSubArray(new int[]{5, 4, -1, 7, 8}));
        System.out.println(new Solution().maxSubArrayRecursive(new int[]{5, 4, -1, 7, 8}));
    }
}
