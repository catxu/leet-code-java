package com.catxu.leetcode.question463;

/**
 * 463. Island Perimeter
 */
class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) perimeter += dfs(grid, i, j, m, n);
            }
        }
        return perimeter;
    }

    private int dfs(int[][] grid, int row, int col, int m, int n) {
        // 从一个岛屿方格走向网格边界，周长加 1
        if (row < 0 || row >= m || col < 0 || col >= n) return 1;
        // 从一个岛屿方格走向水域方格，周长加 1
        if (grid[row][col] == 0) return 1;
        if (grid[row][col] == 1) {
            grid[row][col] = 2;
            return dfs(grid, row - 1, col, m, n) +
                    dfs(grid, row + 1, col, m, n) +
                    dfs(grid, row, col - 1, m, n) +
                    dfs(grid, row, col + 1, m, n);
        } else { // 已计算过，避免重复计算
            return 0;
        }
    }
}
