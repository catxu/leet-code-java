package com.catxu.leetcode.question407;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 407. Trapping Rain Water II
 */
class Solution {
    public int trapRainWater(int[][] heightMap) {
        // Dijkstra = PQ + BFS
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int m = heightMap.length, n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        // 初始化最外层 border
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    pq.offer(new int[]{heightMap[i][j], i, j});
                    visited[i][j] = true;
                }
            }
        }

        // cur: 当前“水位线”
        int cur = -1, ans = 0;
        int[][] dir = {
                {-1, 0}, // Up
                {1, 0}, // Down
                {0, -1}, // Left
                {0, 1} // Right
        };
        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int h = cell[0], i = cell[1], j = cell[2];
            if (cur < h) cur = h;
            ans += cur - h;
            for (int k = 0; k < 4; k++) {
                int x = i + dir[k][0], y = j + dir[k][1];
                if (x < 0 || x == m || y < 0 || y == n) continue;
                if (visited[x][y]) continue;
                pq.offer(new int[]{heightMap[x][y], x, y});
                visited[x][y] = true;
            }
        }
        return ans;
    }
}
