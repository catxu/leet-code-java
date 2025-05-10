package com.catxu.leetcode.question1995;

/**
 * 1995. Count Special Quadruplets
 */
class Solution {
    public int countQuadruplets(int[] nums) {
        int n = nums.length, ans = 0;
        int[] cnt = new int[300]; // a + b + c 最大 300
        for (int b = n - 3; b >= 1; b--) {
            for (int d = b + 2; d < n; d++) {
                cnt[nums[d] - nums[b + 1] + 99]++; // d c 最大差为 -99
            }
            for (int a = 0; a < b; a++) {
                ans += cnt[nums[a] + nums[b] + 99];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countQuadruplets(new int[]{1, 2, 3, 6}));
    }
}
