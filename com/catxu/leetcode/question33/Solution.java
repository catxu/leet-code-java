package com.catxu.leetcode.question33;

/**
 * 33. Search in Rotated Sorted Array
 * <p>
 * There is an integer array nums sorted in ascending order (with distinct values).
 * <p>
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 * <p>
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 * Example 1:
 * <pre>
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * </pre>
 * <p>
 * Example 2:
 * <pre>
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * </pre>
 * Example 3:
 * <pre>
 * Input: nums = [1], target = 0
 * Output: -1
 * </pre>
 */
class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[l] <= nums[mid]) {
                // left sorted portion
                if (target > nums[mid] || target < nums[l]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                // right sorted portion
                if (target < nums[mid] || target > nums[r]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(s.search(new int[]{1}, 3));
        System.out.println(s.search(new int[]{5, 1, 3}, 5));
        System.out.println(s.search(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 8));
    }
}
