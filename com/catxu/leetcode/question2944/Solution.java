package com.catxu.leetcode.question2944;

import java.util.HashMap;
import java.util.Map;

/**
 * 2944. Minimum Number of Coins for Fruits
 * <p>
 * You are given an 1-indexed integer array prices where prices[i] denotes the number of coins needed to purchase the i<sup>th</sup> fruit.
 * <p>
 * The fruit market has the following reward for each fruit:
 * <p>
 * If you purchase the i<sup>th</sup> fruit at prices[i] coins, you can get any number of the next i fruits for free.
 * Note that even if you can take fruit j for free, you can still purchase it for prices[j] coins to receive its reward.
 * <p>
 * Return the minimum number of coins needed to acquire all the fruits.
 * <p>
 * Example 1:
 * <pre>
 * Input: prices = [3,1,2]
 * Output: 4
 * Explanation:
 * Purchase the 1st fruit with prices[0] = 3 coins, you are allowed to take the 2nd fruit for free.
 * Purchase the 2nd fruit with prices[1] = 1 coin, you are allowed to take the 3rd fruit for free.
 * Take the 3rd fruit for free.
 * Note that even though you could take the 2nd fruit for free as a reward of buying 1st fruit, you purchase it to receive its reward, which is more optimal.
 * </pre>
 * Example 2:
 * <pre>
 * Input: prices = [1,10,1,1]
 * Output: 2
 * Explanation:
 * Purchase the 1st fruit with prices[0] = 1 coin, you are allowed to take the 2nd fruit for free.
 * Take the 2nd fruit for free.
 * Purchase the 3rd fruit for prices[2] = 1 coin, you are allowed to take the 4th fruit for free.
 * Take the 4th fruit for free.
 * </pre>
 * Example 3:
 * <pre>
 * Input: prices = [26,18,6,12,49,7,45,45]
 * Output: 39
 * Explanation:
 * Purchase the 1st fruit with prices[0] = 26 coin, you are allowed to take the 2nd fruit for free.
 * Take the 2nd fruit for free.
 * Purchase the 3rd fruit for prices[2] = 6 coin, you are allowed to take the 4th, 5th and 6th (the next three) fruits for free.
 * Take the 4th fruit for free.
 * Take the 5th fruit for free.
 * Purchase the 6th fruit with prices[5] = 7 coin, you are allowed to take the 8th and 9th fruit for free.
 * Take the 7th fruit for free.
 * Take the 8th fruit for free.
 * Note that even though you could take the 6th fruit for free as a reward of buying 3rd fruit, you purchase it to receive its reward, which is more optimal.
 * </pre>
 * Constraints:
 * <pre>
 * 1 <= prices.length <= 1000
 * 1 <= prices[i] <= 10<sup>5</sup>
 * </pre>
 */
class Solution {
    public int minimumCoins(int[] prices) {
        Map<String, Integer> memo = new HashMap<>();
        return dfs(1, prices, 0, memo);
    }

    private int dfs(int i, int[] prices, int remainOffer, Map<String, Integer> memo) {
        if (i > prices.length) {
            return 0;
        }
        // Create a unique key for the current state
        String key = i + "," + remainOffer;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int best = prices[i - 1] + dfs(i + 1, prices, i, memo);
        if (remainOffer > 0) {
            best = Math.min(best, dfs(i + 1, prices, remainOffer - 1, memo));
        }
        memo.put(key, best);
        return best;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimumCoins(new int[]{3, 1, 2}));
        System.out.println(new Solution().minimumCoins(new int[]{1, 10, 1, 1}));
        System.out.println(new Solution().minimumCoins(new int[]{26, 18, 6, 12, 49, 7, 45, 45}));
    }
}
