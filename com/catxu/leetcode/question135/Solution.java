package com.catxu.leetcode.question135;

import java.util.Arrays;

/**
 * 135. Candy
 * <p>
 * There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
 * <p>
 * You are giving candies to these children subjected to the following requirements:
 * <p>
 * Each child must have at least one candy.
 * <p>
 * Children with a higher rating get more candies than their neighbors.
 * <p>
 * Return the minimum number of candies you need to have to distribute the candies to the children.
 * <p>
 * Example 1:
 * <pre>
 * Input: ratings = [1,0,2]
 * Output: 5
 * Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
 * </pre>
 * Example 2:
 * <pre>
 * Input: ratings = [1,2,2]
 * Output: 4
 * Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
 * The third child gets 1 candy because it satisfies the above two conditions.
 * </pre>
 * <p>
 * Constraints:
 * <p>
 * n == ratings.length
 * <p>
 * 1 <= n <= 2 * 10<sup>4</sup>
 * <p>
 * 0 <= ratings[i] <= 2 * 10<sup>4</sup>
 */
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        return Arrays.stream(candies).sum();
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.candy(new int[]{1, 0, 2}));
        System.out.println(s.candy(new int[]{1, 2, 2}));
        System.out.println(s.candy(new int[]{3, 2, 1, 3, 2, 1}));
    }
}
