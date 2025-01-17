package com.catxu.leetcode.question3097;

/**
 * 3097. Shortest Subarray With OR at Least K II
 * <p>
 * Constraints:
 * <pre>
 * 1 <= nums.length <= 2 * 10<sup>5</sup>
 * 0 <= nums[i] <= 10<sup>9</sup>
 * 0 <= k <= 10<sup>9</sup>
 * </pre>
 */
class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (x >= k) {
                return 1;
            }
            for (int j = i - 1; j >= 0 && (nums[j] | x) != nums[j]; j--) {
                nums[j] |= x;
                if (nums[j] >= k) {
                    res = Math.min(res, i - j + 1);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimumSubarrayLength(new int[]{1, 2}, 3));
        System.out.println(new Solution().minimumSubarrayLength(new int[]{2, 2, 2, 3, 5}, 8));
    }
}
