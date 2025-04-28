package com.catxu.leetcode.question2302;

/**
 * 2302. Count Subarrays With Score Less Than K
 */
class Solution {

    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        long ans = 0, sum = 0;
        for (int left = 0, right = 0; right < n; right++) {
            sum += nums[right];
            while (sum * (right - left + 1) >= k) {
                sum -= nums[left];
                left++;
            }
            ans += right - left + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countSubarrays(new int[]{1, 1}, 5));
    }
}
