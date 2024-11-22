package com.catxu.leetcode.question34;

import java.util.Arrays;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 * <p>
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 * <p>
 * If target is not found in the array, return [-1, -1].
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 8
 * <p>
 * Output: [3,4]
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 6
 * <p>
 * Output: [-1,-1]
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [], target = 0
 * <p>
 * Output: [-1,-1]
 * <p>
 * Constraints:
 * <p>
 * 0 <= nums.length <= 10<sup>5</sup>
 * <p>
 * -10<sup>9</sup> <= nums[i] <= 10<sup>9</sup>
 * <p>
 * nums is a non-decreasing array.
 * <p>
 * -10<sup>9</sup> <= target <= 10<sup>9</sup>
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return expandFromIndex(nums, mid, target);
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }

    private int[] expandFromIndex(int[] nums, int index, int target) {
        int l = index, r = index;
        while (l >= 0 && target == nums[l]) {
            l--;
        }
        if (l < 0 || nums[l] != target) {
            l++;
        }
        while (r <= nums.length - 1 && target == nums[r]) {
            r++;
        }
        if (r > nums.length - 1 || nums[r] != target) {
            r--;
        }
        return new int[]{l, r};
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(s.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 9)));
        System.out.println(Arrays.toString(s.searchRange(new int[]{8, 8}, 8)));
        System.out.println(Arrays.toString(s.searchRange(new int[]{8, 8, 8}, 8)));
        System.out.println(Arrays.toString(s.searchRange(new int[]{}, 8)));
    }
}