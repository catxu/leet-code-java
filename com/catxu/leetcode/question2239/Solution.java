package com.catxu.leetcode.question2239;

/**
 * 2239. Find Closest Number to Zero
 * <p>
 * Given an integer array nums of size n, return the number with the value closest to 0 in nums. If there are multiple answers, return the number with the largest value.
 * <p>
 * Example 1:
 * <pre>
 * Input: nums = [-4,-2,1,4,8]
 * Output: 1
 * Explanation:
 * The distance from -4 to 0 is |-4| = 4.
 * The distance from -2 to 0 is |-2| = 2.
 * The distance from 1 to 0 is |1| = 1.
 * The distance from 4 to 0 is |4| = 4.
 * The distance from 8 to 0 is |8| = 8.
 * Thus, the closest number to 0 in the array is 1.
 * </pre>
 * Example 2:
 * <pre>
 * Input: nums = [2,-1,1]
 * Output: 1
 * Explanation: 1 and -1 are both the closest numbers to 0, so 1 being larger is returned.
 * </pre>
 * Constraints:
 * <pre>
 * 1 <= n <= 1000
 * -10<sup>5</sup> <= nums[i] <= 10<sup>5</sup>
 * </pre>
 */
class Solution {
    public int findClosestNumber(int[] nums) {
        if (nums.length <= 1) {
            return nums[0];
        }
        int l = 0, r = nums.length - 1;
        int ans = nums[l];
        while (l++ <= r--) {
            int cur = minLarger(nums[l], nums[r]);
            if (Math.abs(cur) < Math.abs(ans)) {
                ans = cur;
            } else if (Math.abs(cur) == Math.abs(ans)) {
                ans = Math.max(cur, ans);
            }
        }
        return ans;
    }

    private int minLarger(int a, int b) {
        int res = Math.abs(a) - Math.abs(b);
        if (res > 0) {
            return b;
        } else if (res < 0) {
            return a;
        } else {
            return Math.max(a, b);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findClosestNumber(new int[]{-4, -2, 1, 4, 8}));
        System.out.println(new Solution().findClosestNumber(new int[]{2, -1, 1}));
    }
}
