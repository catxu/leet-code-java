package com.catxu.leetcode.question122;

/**
 * 122. Best Time to Buy and Sell Stock II
 * <p>
 * You are given an array prices where prices[i] is the price of a given stock on the i<sup>th</sup> day.
 * <p>
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
 * <p>
 * Find and return the maximum profit you can achieve.
 * <p>
 * Example 1:
 * <p>
 * Input: prices = [7,1,5,3,6,4]
 * <p>
 * Output: 7
 * <p>
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Total profit is 4 + 3 = 7.
 * <p>
 * Example 2:
 * <p>
 * Input: prices = [1,2,3,4,5]
 * <p>
 * Output: 4
 * <p>
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Total profit is 4.
 * <p>
 * Example 3:
 * <p>
 * Input: prices = [7,6,4,3,1]
 * <p>
 * Output: 0
 * <p>
 * Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
 * <p>
 * Constraints:
 * <p>
 * 1 <= prices.length <= 3 * 10<sup>4</sup>
 * <p>
 * 0 <= prices[i] <= 10<sup>4</sup>
 */
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;

        // Iterate through the price array
        for (int i = 0; i < prices.length - 1; i++) {
            // If the next day's price is higher, add the difference to profit
            if (prices[i + 1] > prices[i]) {
                profit += prices[i + 1] - prices[i];
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(s.maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(s.maxProfit(new int[]{1, 2}));
        System.out.println(s.maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(s.maxProfit(new int[]{3, 2, 6, 5, 0, 3}));
    }
}
