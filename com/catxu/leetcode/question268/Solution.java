package com.catxu.leetcode.question268;

/**
 * 268. Missing Number
 */
class Solution {
    public int missingNumber(int[] nums) {
        // 原地hash
        int i, n = nums.length;
        for (i = 0; i < n; i++) {
            while (i != nums[i] && nums[i] != n) swap(nums, i, nums[i]);
        }
        for (i = 0; i < n; i++) {
            if (i != nums[i]) return i;
        }
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().missingNumber(new int[]{3, 0, 1}));
        System.out.println(new Solution().missingNumber(new int[]{0, 1}));
        System.out.println(new Solution().missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }
}
