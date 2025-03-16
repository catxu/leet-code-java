package com.catxu.leetcode.question162;

/**
 * 162. Find Peak Element
 */
class Solution {

    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findPeakElement(new int[]{1, 2, 3, 1}));
        System.out.println(new Solution().findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
    }
}