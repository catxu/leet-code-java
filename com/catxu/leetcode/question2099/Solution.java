package com.catxu.leetcode.question2099;

import java.util.Arrays;

/**
 * 2099. Find Subsequence of Length K With the Largest Sum
 */
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        Integer[] idx = new Integer[n];
        Arrays.setAll(idx, i -> i);
        Arrays.sort(idx, (i, j) -> nums[j] - nums[i]); // 根据
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = idx[i];
        }
        Arrays.sort(ans);
        for (int i = 0; i < k; i++) {
            ans[i] = nums[ans[i]];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().maxSubsequence(new int[]{3, -1, 4, -2}, 3)));
    }
}
