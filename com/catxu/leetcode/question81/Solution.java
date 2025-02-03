package com.catxu.leetcode.question81;

/**
 * 81. Search in Rotated Sorted Array II
 */
class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[l] == nums[mid] && nums[mid] == nums[r]) {
                ++l;
                --r;
            } else if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
        System.out.println(new Solution().search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3));
        System.out.println(new Solution().search(new int[]{2}, 2));
    }
}
