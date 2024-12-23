package com.catxu.leetcode.question198;

/**
 * 198. House Robber
 * <p>
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1]
 * <p>
 * Output: 4
 * <p>
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * <p>
 * Total amount you can rob = 1 + 3 = 4.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [2,7,9,3,1]
 * <p>
 * Output: 12
 * <p>
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * <p>
 * Total amount you can rob = 2 + 9 + 1 = 12.
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 100
 * <p>
 * 0 <= nums[i] <= 400
 */
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().rob(new int[]{1, 2, 3, 1}));
        System.out.println(new Solution().rob(new int[]{1}));
        System.out.println(new Solution().rob(new int[]{3, 1}));
        System.out.println(new Solution().rob(new int[]{1, 1, 10, 0, 1, 90}));
        System.out.println(new Solution().rob(new int[]{10, 0, 1, 90}));
        System.out.println(new Solution().rob(new int[]{2, 7, 9, 3, 1, 10}));
    }
}
