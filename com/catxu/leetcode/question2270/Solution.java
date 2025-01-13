package com.catxu.leetcode.question2270;

import java.util.Arrays;

/**
 * 2270. Number of Ways to Split Array
 * <p>
 * You are given a 0-indexed integer array nums of length n.
 * <p>
 * nums contains a valid split at index i if the following are true:
 * <p>
 * The sum of the first i + 1 elements is greater than or equal to the sum of the last n - i - 1 elements.
 * <p>
 * There is at least one element to the right of i. That is, 0 <= i < n - 1.
 * <p>
 * Return the number of valid splits in nums.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [10,4,-8,7]
 * <p>
 * Output: 2
 * <pre>
 * Explanation:
 * There are three ways of splitting nums into two non-empty parts:
 * - Split nums at index 0. Then, the first part is [10], and its sum is 10. The second part is [4,-8,7], and its sum is 3. Since 10 >= 3, i = 0 is a valid split.
 * - Split nums at index 1. Then, the first part is [10,4], and its sum is 14. The second part is [-8,7], and its sum is -1. Since 14 >= -1, i = 1 is a valid split.
 * - Split nums at index 2. Then, the first part is [10,4,-8], and its sum is 6. The second part is [7], and its sum is 7. Since 6 < 7, i = 2 is not a valid split.
 * Thus, the number of valid splits in nums is 2.
 * </pre>
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [2,3,1,0]
 * Output: 2
 * <pre>
 * Explanation:
 * There are two valid splits in nums:
 * - Split nums at index 1. Then, the first part is [2,3], and its sum is 5. The second part is [1,0], and its sum is 1. Since 5 >= 1, i = 1 is a valid split.
 * - Split nums at index 2. Then, the first part is [2,3,1], and its sum is 6. The second part is [0], and its sum is 0. Since 6 >= 0, i = 2 is a valid split.
 * </pre>
 * Constraints:
 * <p>
 * 2 <= nums.length <= 10<sup>5</sup>
 * <p>
 * -10<sup>5</sup> <= nums[i] <= 10<sup>5</sup>
 */
class Solution {
    public int waysToSplitArray(int[] nums) {
        int l = -1, n = nums.length - 1, ans = 0;
        long lSum = 0, rSum = Arrays.stream(nums).asLongStream().sum();
        while (++l < n) {
            lSum += nums[l];
            rSum -= nums[l];
            if (lSum >= rSum) {
                ans += 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().waysToSplitArray(new int[]{10, 4, -8, 7}));
        System.out.println(new Solution().waysToSplitArray(new int[]{2, 3, 1, 0}));
    }
}
