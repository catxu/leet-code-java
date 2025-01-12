package com.catxu.leetcode.weekly432.q1;

import java.util.ArrayList;
import java.util.List;

/**
 * Q1. Zigzag Grid Traversal With Skip
 */
public class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < grid[i].length; j += 2) {
                    ans.add(grid[i][j]);
                }
            } else {
                int j;
                if (grid[i].length % 2 == 0) {
                    j = grid[i].length - 1;
                } else {
                    j = grid[i].length - 2;
                }
                for (; j >= 0; j -= 2) {
                    ans.add(grid[i][j]);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().zigzagTraversal(new int[][]{
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        }));
        System.out.println(new Solution().zigzagTraversal(new int[][]{
                {1, 2}, {3, 4}
        }));
        System.out.println(new Solution().zigzagTraversal(new int[][]{
                {2, 1}, {2, 1}, {2, 1}
        }));
    }
}
