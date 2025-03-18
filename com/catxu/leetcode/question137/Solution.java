package com.catxu.leetcode.question137;

/**
 * 137. Single Number II
 */
class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int setBitCount = 0;
            for (int num : nums) {
                setBitCount += (num >> i) & 1;
            }
            if (setBitCount % 3 != 0) {
                ans += (1 << i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().singleNumber(new int[]{2, 2, 3, 2}));
        System.out.println(new Solution().singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99}));
    }
}
