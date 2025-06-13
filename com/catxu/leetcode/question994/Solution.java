package com.catxu.leetcode.question994;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 994. Rotting Oranges
 */
class Solution {
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m, n;

    public int orangesRotting(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) q.offer(new int[]{i, j});
            }
        }
        int ans = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) { // 多源bfs：遍历当前层所有相邻的好果子，污染之
                int[] rc = q.poll();
                int r = rc[0], c = rc[1];
                if (!vis[r][c]) {
                    vis[r][c] = true;
                    for (int[] d : dirs) {
                        int nr = d[0] + r, nc = d[1] + c;
                        if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                        if (grid[nr][nc] == 1) {
                            grid[nr][nc] = 2;
                            q.offer(new int[]{nr, nc});
                        }
                    }
                }
            }
            ans++;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }
        return ans == -1 ? 0 : ans;
    }

}
