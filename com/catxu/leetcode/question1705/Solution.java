package com.catxu.leetcode.question1705;

import java.util.Stack;

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
 * <p>
 * Input: apples = [1,2,3,5,2], days = [3,2,1,4,2]
 * <p>
 * Output: 7
 * <p>
 * Explanation: You can eat 7 apples:
 * <p>
 * - On the first day, you eat an apple that grew on the first day.
 * <p>
 * - On the second day, you eat an apple that grew on the second day.
 * <p>
 * - On the third day, you eat an apple that grew on the second day. After this day, the apples that grew on the third day rot.
 * <p>
 * - On the fourth to the seventh days, you eat apples that grew on the fourth day.
 * <p>
 * Example 2:
 * <p>
 * Input: apples = [3,0,0,0,0,2], days = [3,0,0,0,0,2]
 * <p>
 * Output: 5
 * <p>
 * Explanation: You can eat 5 apples:
 * <p>
 * - On the first to the third day you eat apples that grew on the first day.
 * <p>
 * - Do nothing on the fourth and fifth days.
 * <p>
 * - On the sixth and seventh days you eat apples that grew on the sixth day.
 * <p>
 * Constraints:
 * <p>
 * n == apples.length == days.length
 * <p>
 * 1 <= n <= 2 * 10<sup>4</sup>
 * <p>
 * 0 <= apples[i], days[i] <= 2 * 104
 * <p>
 * days[i] = 0 if and only if apples[i] = 0.
 */
class Solution {
    public int eatenApples(int[] apples, int[] days) {
        // 最大吃苹果数 = 吃上苹果的天数
        // 维护一个剩余苹果数量 用栈来装 每天如果产生了新苹果，就入栈，peek() 校验 day 为 0 或者 apple 为 0 ，任意一个为 0 就 pop 出栈
        // 另外还需要跟踪索引， 有可能 后进的 却先过期了 [7, 1, 2, 9] / [7, 1, 2, 9]
        // 索引表示第 i 天入栈的，如果取出来 maxDay > i + days[i] 则表示已过期
        // 特殊条件，如果 days[i] == 0 则不过期？
        if (apples.length == 0) {
            return 0;
        }
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < apples.length; i++) {
            stack.addFirst(new int[]{apples[i], days[i], i + 1});
        }
        int ans = 0, curDay = 1;
        while (!stack.isEmpty()) {
            int[] appleToEat = stack.peek();
            if (appleToEat[0] > 0 &&  (appleToEat[2] /*起始时间*/ + appleToEat[1] /*最大保存时间*/) >= curDay) {
                curDay++;
                ans += 1;
                appleToEat[0] = appleToEat[0] - 1;
            } else {
                stack.pop();
            }
        }
        return ans;
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
