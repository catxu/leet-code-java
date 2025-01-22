package com.catxu.leetcode.question1561;

import java.util.Arrays;

/**
 * 1561. Maximum Number of Coins You Can Get
 */
class Solution {
    public int maxCoins(int[] piles) {
        piles = Arrays.stream(piles)
                .boxed()
                .sorted((a, b) -> b - a)
                .mapToInt(Integer::intValue)
                .toArray();
        int ans = 0, cnt = piles.length / 3;
        for (int i = 1, j = 1; j <= cnt; i += 2, j++) {
            ans += piles[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxCoins(new int[]{2, 4, 1, 2, 7, 8}));
        System.out.println(new Solution().maxCoins(new int[]{2, 4, 5}));
        System.out.println(new Solution().maxCoins(new int[]{9, 8, 7, 6, 5, 1, 2, 3, 4}));
    }
}
