package com.catxu.leetcode.question1742;

/**
 * 1742. Maximum Number of Balls in a Box
 * <p>
 * You are working in a ball factory where you have n balls numbered from lowLimit up to highLimit inclusive (i.e., n == highLimit - lowLimit + 1), and an infinite number of boxes numbered from 1 to infinity.
 * <p>
 * Your job at this factory is to put each ball in the box with a number equal to the sum of digits of the ball's number. For example, the ball number 321 will be put in the box number 3 + 2 + 1 = 6 and the ball number 10 will be put in the box number 1 + 0 = 1.
 * <p>
 * Given two integers lowLimit and highLimit, return the number of balls in the box with the most balls.
 * <p>
 * Example 1:
 * <pre>
 * Input: lowLimit = 1, highLimit = 10
 * Output: 2
 * Explanation:
 * Box Number:  1 2 3 4 5 6 7 8 9 10 11 ...
 * Ball Count:  2 1 1 1 1 1 1 1 1 0  0  ...
 * Box 1 has the most number of balls with 2 balls.
 * </pre>
 * Example 2:
 * <pre>
 * Input: lowLimit = 5, highLimit = 15
 * Output: 2
 * Explanation:
 * Box Number:  1 2 3 4 5 6 7 8 9 10 11 ...
 * Ball Count:  1 1 1 1 2 2 1 1 1 0  0  ...
 * Boxes 5 and 6 have the most number of balls with 2 balls in each.
 * </pre>
 * Example 3:
 * <pre>
 * Input: lowLimit = 19, highLimit = 28
 * Output: 2
 * Explanation:
 * Box Number:  1 2 3 4 5 6 7 8 9 10 11 12 ...
 * Ball Count:  0 1 1 1 1 1 1 1 1 2  0  0  ...
 * Box 10 has the most number of balls with 2 balls.
 * </pre>
 * <p>
 * Constraints:
 * <pre>
 * 1 <= lowLimit <= highLimit <= 10<sup>5</sup>
 * </pre>
 */
class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        int[] arr = new int[46];
        int ans = 0;
        while (lowLimit <= highLimit) {
            int t = lowLimit, sum = 0;
            while (t > 0) {
                sum += (t % 10);
                t /= 10;
            }
            arr[sum]++;
            ans = Math.max(ans, arr[sum]);
            lowLimit++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countBalls(1, 10));
        System.out.println(new Solution().countBalls(5, 15));
        System.out.println(new Solution().countBalls(19, 28));
    }
}
