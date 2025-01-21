package com.catxu.leetcode.question300;

import java.util.Arrays;

/**
 * 300. Longest Increasing Subsequence
 * <p>
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 * <p>
 * Example 1:
 * <pre>
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * </pre>
 * Example 2:
 * <pre>
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * </pre>
 * Example 3:
 * <pre>
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 * </pre>
 * Constraints:
 * <pre>
 * 1 <= nums.length <= 2500
 * -10<sup>4</sup> <= nums[i] <= 10<sup>4</sup>
 * </pre>
 * Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        int ans = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(new Solution().lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        System.out.println(new Solution().lengthOfLIS(new int[]{7, 7, 7, -7, 7, 7, 7}));
        System.out.println(new Solution().lengthOfLIS(new int[]{0}));
    }
}