package com.catxu.leetcode.question704;

/**
 * 704.Binary Search
 */
class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        // 闭区间二分
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l < nums.length && nums[l] == target ? l : -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(new Solution().search(new int[]{-1, 0, 3, 5, 9}, 13));
    }
}
