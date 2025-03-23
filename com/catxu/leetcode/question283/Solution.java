package com.catxu.leetcode.question283;

import java.util.Arrays;

/**
 * 283. Move Zeroes
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int s = 0, f = 0;
        while (f < n) {
            if (nums[f] != 0) {
                swap(nums, s, f);
                s++;
            }
            f++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{0, 1, 0, 3, 12};
        Solution solution = new Solution();
        solution.moveZeroes(nums1);
        System.out.println(Arrays.toString(nums1));
    }
}
