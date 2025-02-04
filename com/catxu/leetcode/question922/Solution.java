package com.catxu.leetcode.question922;

import java.util.Arrays;

/**
 * 922. Sort Array By Parity II
 */
class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int prev = 1;
        for (int i = 0; i < nums.length; i += 2) {
            if (nums[i] % 2 != 0) {
                while (nums[prev] % 2 != 0) {
                    prev += 2;
                }
                swap(nums, i, prev);
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().sortArrayByParityII(new int[]{4, 2, 5, 7, 3, 2})));
        System.out.println(Arrays.toString(new Solution().sortArrayByParityII(new int[]{4, 2, 5, 7, 3, 0, 0, 1})));
        System.out.println(Arrays.toString(new Solution().sortArrayByParityII(new int[]{2, 3})));
    }
}
