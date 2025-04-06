package com.catxu.leetcode.question189;

import java.util.Arrays;
import java.util.Stack;

/**
 * 189. Rotate Array
 * <p>
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * <p>
 * Output: [5,6,7,1,2,3,4]
 * <p>
 * Explanation:
 * <p>
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * <p>
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * <p>
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [-1,-100,3,99], k = 2
 * <p>
 * Output: [3,99,-1,-100]
 * <p>
 * Explanation:
 * <p>
 * rotate 1 steps to the right: [99,-1,-100,3]
 * <p>
 * rotate 2 steps to the right: [3,99,-1,-100]
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10<sup>5</sup>
 * <p>
 * -2<sup>31</sup> <= nums[i] <= 2<sup>31</sup> - 1
 * <p>
 * 0 <= k <= 10<sup>5</sup>
 */
class Solution {

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) {
            return;
        }
        // 1,2,3,4  k = 2  length - 1 = 3
        // 2,1,3,4  k = 2  length - 1 = 3
        reverse(nums, 0, nums.length - k - 1);
        // 2,1,4,3  k = 2  length - k = 2
        reverse(nums, nums.length - k, nums.length - 1);
        // 3,4,1,2  k = 2  length - k = 2
        reverse(nums, 0, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int t = nums[start];
            nums[start] = nums[end];
            nums[end] = t;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ex1 = {1, 2, 3, 4, 5, 6, 7};
        solution.rotate(ex1, 3);
        System.out.println(Arrays.toString(ex1));
        int[] ex2 = {-1, -100, 3, 99};
        solution.rotate(ex2, 2);
        System.out.println(Arrays.toString(ex2));
        int[] ex3 = {1, 2};
        solution.rotate(ex3, 5);
        System.out.println(Arrays.toString(ex3));
    }

}
