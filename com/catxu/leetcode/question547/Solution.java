package com.catxu.leetcode.question547;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 547. Number of Provinces
 */
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    g.putIfAbsent(i, new LinkedList<>());
                    continue;
                }
                if (isConnected[i][j] == 1) g.computeIfAbsent(i, v -> new LinkedList<>()).add(j);
            }
        }
    }
}
