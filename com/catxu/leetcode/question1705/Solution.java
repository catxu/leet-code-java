package com.catxu.leetcode.question1705;

import java.util.PriorityQueue;

/**
 * 1705. Maximum Number of Eaten Apples
 * <p>
 * There is a special kind of apple tree that grows apples every day for n days. On the i<sup>th</sup> day, the tree grows apples[i] apples that will rot after days[i] days, that is on day i + days[i] the apples will be rotten and cannot be eaten. On some days, the apple tree does not grow any apples, which are denoted by apples[i] == 0 and days[i] == 0.
 * <p>
 * You decided to eat at most one apple a day (to keep the doctors away). Note that you can keep eating after the first n days.
 * <p>
 * Given two integer arrays days and apples of length n, return the maximum number of apples you can eat.
 * <p>
 * Example 1:
 * <pre>
 * Input: apples = [1,2,3,5,2], days = [3,2,1,4,2]
 * Output: 7
 * Explanation: You can eat 7 apples:
 * - On the first day, you eat an apple that grew on the first day.
 * - On the second day, you eat an apple that grew on the second day.
 * - On the third day, you eat an apple that grew on the second day. After this day, the apples that grew on the third day rot.
 * - On the fourth to the seventh days, you eat apples that grew on the fourth day.
 * </pre>
 * Example 2:
 * <pre>
 * Input: apples = [3,0,0,0,0,2], days = [3,0,0,0,0,2]
 * Output: 5
 * Explanation: You can eat 5 apples:
 * - On the first to the third day you eat apples that grew on the first day.
 * - Do nothing on the fourth and fifth days.
 * - On the sixth and seventh days you eat apples that grew on the sixth day.
 * </pre>
 * Constraints:
 * <pre>
 * n == apples.length == days.length
 * 1 <= n <= 2 * 10<sup>4</sup>
 * 0 <= apples[i], days[i] <= 2 * 10<sup>4</sup>
 * days[i] = 0 if and only if apples[i] = 0.
 * </pre>
 */
class Solution {
    public int eatenApples(int[] apples, int[] days) {
        int n = apples.length;
        int day = 0, eaten = 0;

        // Min-Heap to store [expirationDay, appleCount]
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        while (day < n || !heap.isEmpty()) {
            // Add today's apples with expiration day
            if (day < n && apples[day] > 0) {
                heap.offer(new int[]{day + days[day], apples[day]});
            }

            // Remove all rotten apples
            while (!heap.isEmpty() && heap.peek()[0] <= day) {
                heap.poll();
            }

            // Eat an apple if available
            if (!heap.isEmpty()) {
                int[] top = heap.poll();
                top[1]--; // Eat one apple
                eaten++;

                // If there are apples left, add back to the heap
                if (top[1] > 0) {
                    heap.offer(top);
                }
            }

            // Move to the next day
            day++;
        }

        return eaten;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.eatenApples(new int[]{1, 2, 3, 5, 2}, new int[]{3, 2, 1, 4, 2}));
        System.out.println(solution.eatenApples(new int[]{3}, new int[]{2}));
        System.out.println(solution.eatenApples(new int[]{3, 0, 0, 0, 2}, new int[]{3, 0, 0, 0, 2}));
        System.out.println(solution.eatenApples(new int[]{3, 1, 0, 0, 2}, new int[]{0, 2, 0, 0, 2}));
        System.out.println(solution.eatenApples(new int[]{0, 0, 0, 0}, new int[]{0, 0, 0, 0}));
        System.out.println(solution.eatenApples(new int[]{2, 1, 10, 0, 0}, new int[]{3, 2, 5, 0, 0}));
        System.out.println(solution.eatenApples(new int[]{1, 2, 3, 4, 5}, new int[]{1, 10, 10, 10, 10}));
        System.out.println(solution.eatenApples(new int[]{1}, new int[]{0}));
        System.out.println(solution.eatenApples(new int[]{2, 1, 10}, new int[]{2, 10, 1}));
    }
}
