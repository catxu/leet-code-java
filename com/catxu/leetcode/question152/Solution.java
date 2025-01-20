package com.catxu.leetcode.question152;

/**
 * 152. Maximum Product Subarray
 */
class Solution {
    public int maxProduct(int[] nums) {
        int length = nums.length;
        // maximum
        int[] f = new int[length];
        // minimum
        int[] g = new int[length];
        f[0] = nums[0];
        g[0] = nums[0];
        int ans = nums[0];
        for (int i = 1; i < length; i++) {
            int x = nums[i];
            f[i] = Math.max(x, Math.max(f[i - 1] * x, g[i - 1] * x));
            g[i] = Math.min(x, Math.min(f[i - 1] * x, g[i - 1] * x));
            ans = Math.max(ans, Math.max(f[i], g[i]));
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(new Solution().maxProduct(new int[]{-2, 0, -1}));
    }
}
