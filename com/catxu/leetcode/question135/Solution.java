package com.catxu.leetcode.question135;

import java.util.Arrays;
import java.util.Stack;

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

        /*int ans = 0, prevRate = 1;
        // 维护连续降序起点
        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i < ratings.length; i++) {
            int prev = ratings[i - 1];
            if (ratings[i] > prev) {
                ans += prevRate + 1 + calcOffset(stack, i);
                prevRate += 1;
            } else if (ratings[i] < prev) {
                prevRate = 1;
                if (!stack.isEmpty()) {
                    continue;
                }
                stack.push(i - 1);
            } else {
                prevRate = 1;
                ans += prevRate + calcOffset(stack, i);
            }
        }
        return ans + calcOffset(stack, ratings.length - 1);*/
    }

    private int calcOffset(Stack<Integer> stack, int i) {
        if (!stack.isEmpty()) {
            int start = stack.pop();
            return (1 + i - start) * (i - start) / 2;
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.candy(new int[]{1, 0, 2}));
//        System.out.println(s.candy(new int[]{1, 2, 2}));
        System.out.println(s.candy(new int[]{3, 2, 1, 3, 2, 1}));
    }
}
