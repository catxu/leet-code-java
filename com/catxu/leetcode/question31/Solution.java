package com.catxu.leetcode.question31;

import java.util.Arrays;

/**
 * 31. Next Permutation
 * <p>
 * A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
 * <p>
 * For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1].
 * The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally,
 * if all the permutations of the array are sorted in one container according to their lexicographical order,
 * then the next permutation of that array is the permutation that follows it in the sorted container.
 * If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).
 * <p>
 * For example, the next permutation of arr = [1,2,3] is [1,3,2].
 * Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
 * While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
 * Given an array of integers nums, find the next permutation of nums.
 * <p>
 * The replacement must be in place and use only constant extra memory.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3]
 * Output: [1,3,2]
 * Example 2:
 * <p>
 * Input: nums = [3,2,1]
 * Output: [1,2,3]
 * Example 3:
 * <p>
 * Input: nums = [1,1,5]
 * Output: [1,5,1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 */
class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        for (int tail = len - 1; tail >= 0; ) {
            int prev = tail - 1;
            if (prev < 0) {
                revert(nums, tail, len - 1);
                return;
            }
            if (nums[tail] > nums[prev]) {
                int slow = len - 1;
                // 从后向前搜索，找到第一个比目标元素大的 元素
                while (nums[slow] <= nums[prev] && slow > tail) {
                    --slow;
                }
                swap(nums, slow, prev);
                // 交换之后，尾部数组一定是降序排列的，需将其翻转为升序，如 [1,3,2] -> [2,3,1] --翻转--> [2,1,3]
                // 翻转尾部的倒序数组
                revert(nums, tail, len - 1);
                return;
            }
            tail--;
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    private void revert(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 2, 3};
        solution.nextPermutation(nums1);
        System.out.println(Arrays.toString(nums1));
        int[] nums2 = {3, 2, 1};
        solution.nextPermutation(nums2);
        System.out.println(Arrays.toString(nums2));
        int[] nums3 = {1, 1, 5};
        solution.nextPermutation(nums3);
        System.out.println(Arrays.toString(nums3));
        int[] nums4 = {1, 5, 1};
        solution.nextPermutation(nums4);
        System.out.println(Arrays.toString(nums4));
        int[] nums5 = {0, 1, 3, 2};
        solution.nextPermutation(nums5);
        System.out.println(Arrays.toString(nums5));
    }
    /*
    0 - 1 - 2 - 3
    0 - 1 - 3 - 2
    0 - 2 - 1 - 3
    0 - 2 - 3 - 1
    0 - 3 - 1 - 2
    0 - 3 - 2 - 1
    1 - 0 - 2 - 3
    1 - 0 - 3 - 2
    1 - 2 - 0 - 3
    1 - 2 - 3 - 0
    1 - 3 - 0 - 2
    1 - 3 - 2 - 0
    2 - 0 - 1 - 3
    2 - 0 - 3 - 1
    2 - 1 - 0 - 3
    2 - 1 - 3 - 0
    2 - 3 - 0 - 1
    2 - 3 - 1 - 0
    3 - 0 - 1 - 2
    3 - 0 - 2 - 1
    3 - 1 - 0 - 2
    3 - 1 - 2 - 0
    3 - 2 - 0 - 1
    3 - 2 - 1 - 0
    */
}