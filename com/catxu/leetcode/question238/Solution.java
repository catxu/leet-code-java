package com.catxu.leetcode.question238;

import java.util.Arrays;

/**
 * 238. Product of Array Except Self
 * <p>
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * <p>
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * <p>
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 * <p>
 * Example 1:
 * <pre>
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * </pre>
 * Example 2:
 * <pre>
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 * </pre>
 * Constraints:
 * <pre>
 * 2 <= nums.length <= 10<sup>5</sup>
 * -30 <= nums[i] <= 30
 * The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.
 * </pre>
 * <p>
 * Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int temp = 1;
        int[] ans = new int[nums.length];
        ans[0] = 1;
        // nums =  2   2   3   4

        // ans[0] = 1            1   2   3   4   temp = 2 * temp
        // ans[1] = 2 * ans[0]   2   1   3   4   temp = 3 * temp
        // ans[2] = 2 * ans[1]   2   2   1   4   temp = 4 * temp
        // ans[3] = 3 * ans[2]   2   2   3   1   temp = 1

        for (int i = 1; i < nums.length; i++) {
            ans[i] = nums[i - 1] * ans[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            temp *= nums[i + 1];
            ans[i] *= temp;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(new Solution().productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
    }
}
