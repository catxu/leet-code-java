package com.catxu.leetcode.question918;

/**
 * 918. Maximum Sum Circular Subarray
 */
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int ans, globalMin, totalSum, curMin, curMax = curMin = globalMin = totalSum = ans = nums[0];
        for (int i = 1; i < n; i++) {
            totalSum += nums[i];
            curMin = Math.min(nums[i], curMin + nums[i]);
            globalMin = Math.min(globalMin, curMin);
            curMax = Math.max(nums[i], curMax + nums[i]);
            ans = Math.max(ans, curMax);
        }

        return ans < 0 ? ans : Math.max(ans, totalSum - globalMin);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxSubarraySumCircular(new int[]{1, -2, 3, -2}));
        System.out.println(new Solution().maxSubarraySumCircular(new int[]{5, -5, 5}));
        System.out.println(new Solution().maxSubarraySumCircular(new int[]{-3, -2, -3}));
        System.out.println(new Solution().maxSubarraySumCircular(new int[]{1, -7, 2}));
        System.out.println(new Solution().maxSubarraySumCircular(new int[]{2, -1,-1, 8, -1, 2}));
    }
}
