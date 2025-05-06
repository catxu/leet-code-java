package com.catxu.leetcode.question1920;

import java.util.Arrays;

/**
 * 1920. Build Array from Permutation
 */
class Solution {
    public int[] buildArray(int[] nums) {
        int i, n = nums.length;
        // 编码最终值
        // 因为 0 <= nums[i] <= 999 故按1000进制进行编码，可保留原始信息和最终值
        for (i = 0; i < n; i++) {
            // nums[nums[i]] 可能已经被编码了，所以需要 % 1000 对其进行还原
            nums[i] += 1000 * (nums[nums[i]] % 1000);
        }
        // 修改为最终值
        for (i = 0; i < n; i++) {
            nums[i] /= 1000;
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        // ans = [0, 1, 2, 4, 5, 3]
        System.out.println(Arrays.toString(new Solution().buildArray(new int[]{0, 2, 1, 5, 3, 4})));
    }
}
