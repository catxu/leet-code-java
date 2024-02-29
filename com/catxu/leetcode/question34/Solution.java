package com.catxu.leetcode.question34;

import java.util.Arrays;

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