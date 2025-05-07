package com.catxu.leetcode.question980;

/**
 * 980. Unique Paths III
 */
class Solution {
    public int uniquePathsIII(int[][] grid) {
        int cnt = 0; // 0 的个数
        int m = grid.length, n = grid[0].length;
        int startX = 0, startY = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) cnt++;
                else if (grid[i][j] == 1) {
                    cnt++; // 起点也算可访问的 0
                    startX = i;
                    startY = j;
                }
            }
        }
        return backtracking(grid, startX, startY, cnt);
    }

    private int backtracking(int[][] grid, int x, int y, int left) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] < 0) {
            return 0;
        }
        if (grid[x][y] == 2) {
            return left == 0 ? 1 : 0;
        }
        int t = grid[x][y];
        grid[x][y] = -1;
        int res = backtracking(grid, x - 1, y, left - 1) +
                backtracking(grid, x + 1, y, left - 1) +
                backtracking(grid, x, y - 1, left - 1) +
                backtracking(grid, x, y + 1, left - 1);
        grid[x][y] = t;
        return res;
    }
}
