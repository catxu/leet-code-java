package com.catxu.leetcode.question645;

import java.util.Arrays;

/**
 * 645. Set Mismatch
 */
class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2], dict = new int[n + 1];

        for (int num : nums) {
            dict[num]++;
        }

        for (int i = 1; i <= n; i++) {
            if (dict[i] == 0)
                ans[1] = i;
            if (dict[i] == 2)
                ans[0] = i;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findErrorNums(new int[]{1, 1})));
        System.out.println(Arrays.toString(new Solution().findErrorNums(new int[]{1, 3, 3, 4})));
        System.out.println(Arrays.toString(new Solution().findErrorNums(new int[]{2, 3, 2})));
        System.out.println(Arrays.toString(new Solution().findErrorNums(new int[]{3, 3, 2})));
        System.out.println(Arrays.toString(new Solution().findErrorNums(new int[]{3, 3, 1})));
    }
}
