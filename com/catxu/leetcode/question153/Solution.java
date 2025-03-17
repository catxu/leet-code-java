package com.catxu.leetcode.question153;

/**
 * 153. Find Minimum in Rotated Sorted Array
 */
class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1] && nums[right] < nums[mid]) {
                left = mid + 1;
            } else if (nums[mid] < nums[mid + 1] && nums[right] > nums[mid]) {
                right = mid;
            } else /*if (nums[mid] > nums[mid + 1])*/ {
                return nums[mid + 1];
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(new Solution().findMin(new int[]{3, 4, 5, 1}));
        System.out.println(new Solution().findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(new Solution().findMin(new int[]{0, 1, 2, 4, 5, 6, 7}));
        System.out.println(new Solution().findMin(new int[]{27, 0}));
    }
}
