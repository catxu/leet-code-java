package com.catxu.leetcode.question1995;

/**
 * 1995. Count Special Quadruplets
 */
class Solution {
    public int countQuadruplets(int[] nums) {
        int n = nums.length, ans = 0;
        int[] cnt = new int[10010];
        for (int c = n - 2; c >= 2; c--) {
            cnt[nums[c + 1]]++;
            for (int a = 0; a < n; a++) {
                for (int b = a + 1; b < c; b++) {
                    ans += cnt[nums[a] + nums[b] + nums[c]];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countQuadruplets(new int[]{1, 2, 3, 6}));
    }
}
