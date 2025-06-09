package com.catxu.leetcode.question733;

/**
 * 733. Flood Fill
 */
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] != color)
            dfs(image, sr, sc, image[sr][sc], color);
        return image;
    }

    private void dfs(int[][] g, int row, int col, int origin, int target) {
        if (row < 0 || row >= g.length || col < 0 || col >= g[0].length) return;
        if (g[row][col] != origin) return;
        g[row][col] = target;
        dfs(g, row - 1, col, origin, target);
        dfs(g, row + 1, col, origin, target);
        dfs(g, row, col - 1, origin, target);
        dfs(g, row, col + 1, origin, target);
    }
}
