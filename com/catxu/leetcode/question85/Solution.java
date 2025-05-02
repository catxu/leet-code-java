package com.catxu.leetcode.question85;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 85. Maximal Rectangle
 */
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length, ans = 0;
        int[] heights = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    heights[j] = 0;
                } else {
                    heights[j]++;
                }
            }
            ans = Math.max(ans, largestRectangleArea(heights));
        }
        return ans;
    }

    // 计算直方图最大矩形面积
    private int largestRectangleArea(int[] heights) {
        int ans = 0, n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            int h = i == n ? 0 : heights[i];
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int weight = stack.isEmpty() ? i : i - stack.peek() - 1;
                ans = Math.max(ans, height * weight);
            }
            stack.push(i);
        }
        return ans;
    }
}
