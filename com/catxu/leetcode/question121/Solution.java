package com.catxu.leetcode.question121;

/**
 * 121. Best Time to Buy and Sell Stock
 * <p>
 * You are given an array prices where prices[i] is the price of a given stock on the i<sup>th</sup> day.
 * <p>
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * <p>
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * <p>
 * Example 1:
 * <p>
 * Input: prices = [7,1,5,3,6,4]
 * <p>
 * Output: 5
 * <p>
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * <p>
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * <p>
 * Example 2:
 * <p>
 * Input: prices = [7,6,4,3,1]
 * <p>
 * Output: 0
 * <p>
 * Explanation: In this case, no transactions are done and the max profit = 0.
 * <p>
 * Constraints:
 * <p>
 * 1 <= prices.length <= 10<sup>5</sup>
 * <p>
 * 0 <= prices[i] <= 10<sup>4</sup>
 */
class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxProfit = 0;

        for (int price : prices) {
            if (price < min) {
                min = price;
            }
            maxProfit = Math.max(maxProfit, price - min);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(s.maxProfit(new int[]{1, 3, 1}));
        System.out.println(s.maxProfit(new int[]{11}));
        System.out.println(s.maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(s.maxProfit(new int[]{3, 2, 6, 5, 0, 3}));
    }
}
