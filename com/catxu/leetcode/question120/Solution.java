package com.catxu.leetcode.question120;

import java.util.List;

/**
 * 120. Triangle
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        for (int i = n - 2; i >= 0; i--) { // bottom-up
            List<Integer> cur = triangle.get(i);
            int m = cur.size();
            List<Integer> prev = triangle.get(i + 1);
            for (int j = 0; j < m; j++) {
                cur.set(j, cur.get(j) + Math.min(prev.get(j), prev.get(j + 1)));
            }
        }
        return triangle.getFirst().getFirst();
    }
}
