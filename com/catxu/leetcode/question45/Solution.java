package com.catxu.leetcode.question45;

import java.util.Arrays;

/**
 * 45. Jump Game II
 * <p>
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
 * <p>
 * Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
 * <pre>
 * 0 <= j <= nums[i] and
 * i + j < n
 * </pre>
 * Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
 * <p>
 * Example 1:
 * <pre>
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * </pre>
 * Example 2:
 * <pre>
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 * </pre>
 * Constraints:
 * <pre>
 * 1 <= nums.length <= 10<sup>4</sup>
 * 0 <= nums[i] <= 1000
 * It's guaranteed that you can reach nums[n - 1].
 * </pre>
 */
class Solution {
    /*public int jump(int[] nums) {
        // dp[i] 跳到 i 最少需要多少步
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] + j >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[nums.length - 1];
    }*/


    public int jump(int[] nums) {
        int res = 0;
        int l = 0, r = 0;
        while (r < nums.length - 1) {
            int farest = 0;
            for (int i = l; i < r + 1; i++) {
                farest = Math.max(farest, i + nums[i]);
            }
            l = r + 1;
            r = farest;
            res += 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(solution.jump(new int[]{2, 3, 0, 1, 4}));
    }
}
