package com.catxu.leetcode.question53;

/**
 * 53. Maximum Subarray
 */
class Solution {
    public int maxSubArray(int[] nums) {
        // dp[i] 表示 [以当前元素为终点，前 k 个元素之和] 与 [以当前元素为起点] 这两者中的最大值
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int ans = dp[0];

        // 1, -3, 9, -8, 10
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

    public int maxSubArrayPrefixSum(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        int ans = sum[0], minPrefixSum = sum[0];
        for (int i = 1; i < n; i++) {
            // i: 0 ans: -2  minPrefixSum: -2
            // i: 1 ans:  1  minPrefixSum: -2  sum[i]: -1   updatedMinPrefixSum: -2
            // i: 2 ans:  1  minPrefixSum: -2  sum[i]: -4   updatedMinPrefixSum: -4
            // i: 3 ans:  4  minPrefixSum: -4  sum[i]: 0    updatedMinPrefixSum: -4
            // i: 4 ans:  4  minPrefixSum: -4  sum[i]: -1   updatedMinPrefixSum: -4
            // i: 5 ans:  5  minPrefixSum: -4  sum[i]: 1    updatedMinPrefixSum: -4
            // i: 6 ans:  6  minPrefixSum: -4  sum[i]: 2    updatedMinPrefixSum: -4
            // i: 7 ans:  6  minPrefixSum: -4  sum[i]: -3   updatedMinPrefixSum: -4
            // i: 8 ans:  6  minPrefixSum: -4  sum[i]: -5   updatedMinPrefixSum: -5
            // i: 9 ans:  7  minPrefixSum: -5  sum[i]: 2    updatedMinPrefixSum: -5
            ans = Math.max(ans, Math.max(sum[i], sum[i] - minPrefixSum));
            // 更新最小前缀和
            minPrefixSum = Math.min(minPrefixSum, sum[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, -2, 7}));
        System.out.println(new Solution().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(new Solution().maxSubArrayRecursive(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(new Solution().maxSubArray(new int[]{1}));
        System.out.println(new Solution().maxSubArrayRecursive(new int[]{1}));
        System.out.println(new Solution().maxSubArray(new int[]{5, 4, -1, 7, 8}));
        System.out.println(new Solution().maxSubArrayRecursive(new int[]{5, 4, -1, 7, 8}));
    }
}
