package com.catxu.leetcode.question41;

/**
 * 41. First Missing Positive
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] >= 1 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                // 原地hash算法：
                // 将数字 1 -> n 映射到 [0, n - 1] 的数组空间
                // 对于下标i，它应该放置的元素值为 i + 1, 即 nums[i] = i + 1
                // 所以给定任意一个元素 1 <= nums[i] <= n，它应该放置在 nums[nums[i] - 1] 的位置上
                // 将 nums[i] 放置到正确的数组位置 nums[i] - 1
                // 使用while重复这个过程直到当前元素不需要再移动：要么 nums[i] < 1 或者 nums[i] > n 要么 nums[i] - 1 这个位置已经是正确的元素
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }
        return n + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(new Solution().firstMissingPositive(new int[]{3, 4, -1, 1, 1}));
        System.out.println(new Solution().firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
    }
}