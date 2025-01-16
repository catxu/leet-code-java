package com.catxu.leetcode.question3295;

/**
 * 3095. Shortest Subarray With OR at Least K I
 * <p>
 * You are given an array nums of non-negative integers and an integer k.
 * <p>
 * An array is called special if the bitwise OR of all of its elements is at least k.
 * <p>
 * Return the length of the shortest special non-empty subarray of nums, or return -1 if no special subarray exists.
 * <p>
 * Example 1:
 * <pre>
 * Input: nums = [1,2,3], k = 2
 * Output: 1
 * Explanation:
 * The subarray [3] has OR value of 3. Hence, we return 1.
 * Note that [2] is also a special subarray.
 * </pre>
 * Example 2:
 * <pre>
 * Input: nums = [2,1,8], k = 10
 * Output: 3
 * Explanation:
 * The subarray [2,1,8] has OR value of 11. Hence, we return 3.
 * </pre>
 * Example 3:
 * <pre>
 * Input: nums = [1,2], k = 0
 * Output: 1
 * Explanation:
 * The subarray [1] has OR value of 1. Hence, we return 1.
 * </pre>
 * <p>
 * Constraints:
 * <pre>
 * 1 <= nums.length <= 50
 * 0 <= nums[i] <= 50
 * 0 <= k < 64
 * </pre>
 */
class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int ans = Integer.MAX_VALUE;
        int s = 0, f = 0, bitwiseORSum = 0;
        while (f < nums.length) {
            bitwiseORSum |= nums[f];
            while (bitwiseORSum >= k && s <= f) {
                ans = Math.min(ans, f - s + 1);
                s++;
                bitwiseORSum = calcORSum(nums, s, f);
            }
            f++;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int calcORSum(int[] nums, int start, int end) {
        int res = 0;
        for (int i = start; i <= end; i++) {
            res |= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimumSubarrayLength(new int[]{1, 2, 3}, 2));
        System.out.println(new Solution().minimumSubarrayLength(new int[]{2, 1, 8}, 10));
        System.out.println(new Solution().minimumSubarrayLength(new int[]{1, 2}, 0));
        System.out.println(new Solution().minimumSubarrayLength(new int[]{16, 1, 2, 20, 32}, 45));

        System.out.println("-*-*-*-*-*-");
        System.out.println(2);
        System.out.println(2 ^ 3);
        System.out.println((2 ^ 3) ^ 3);
        System.out.println("-----------");
        System.out.println(2);
        System.out.println(2 >> 1);
        System.out.println(2 >> 1 << 1);
    }
}
