package com.catxu.leetcode.question209;

/**
 * 209. Minimum Size Subarray Sum
 */
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE, l = 0, r = 0, sum = 0;
        while (r < nums.length) {
            sum += nums[r];
            while (sum >= target) {
                ans = Math.min(ans, r - l + 1);
                sum -= nums[l];
                l++;
            }
            r++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(new Solution().minSubArrayLen(4, new int[]{1, 4, 4}));
        System.out.println(new Solution().minSubArrayLen(11, new int[]{1}));
    }
}