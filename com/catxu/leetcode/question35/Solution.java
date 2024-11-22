package com.catxu.leetcode.question35;

/**
 * 35. Search Insert Position
 * <p>
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,3,5,6], target = 5
 * <p>
 * Output: 2
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1,3,5,6], target = 2
 * <p>
 * Output: 1
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [1,3,5,6], target = 7
 * <p>
 * Output: 4
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10<sup>4</sup>
 * <p>
 * -10<sup>4</sup> <= nums[i] <= 10<sup>4</sup>
 * <p>
 * nums contains distinct values sorted in ascending order.
 * <p>
 * -10<sup>4</sup> <= target <= 10<sup>4</sup>
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            /*if (nums[mid] == target) {
                return mid;
            } else */
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(s.searchInsert(new int[]{0}, -1));
        System.out.println(s.searchInsert(new int[]{0}, 9));
    }
}