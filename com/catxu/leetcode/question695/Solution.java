package com.catxu.leetcode.question695;

/**
 * 695. Max Area of Island
 */
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        UnionFind uf = new UnionFind(grid);

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    int p = r * cols + c;
                    // Check right and down neighbors to avoid double counting
                    if (r + 1 < rows && grid[r + 1][c] == 1) {
                        int q = (r + 1) * cols + c;
                        uf.union(p, q);
                    }
                    if (c + 1 < cols && grid[r][c + 1] == 1) {
                        int q = r * cols + (c + 1);
                        uf.union(p, q);
                    }
                }
            }
        }

        return uf.getMaxSize();
    }
}

class UnionFind {
    private final int[] parent;
    private final int[] size; // Used to track the size of each component
    private int maxSize;

    public UnionFind(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        parent = new int[rows * cols];
        size = new int[rows * cols];
        maxSize = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    int id = r * cols + c;
                    parent[id] = id;
                    size[id] = 1;
                    maxSize = 1; // Initialize maxSize if any land exists
                }
            }
        }
    }

    // Find with path compression
    public int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        parent[i] = find(parent[i]);
        return parent[i];
    }

    // Union by size
    public void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if (rootI != rootJ) {
            // Union by size for optimization
            if (size[rootI] < size[rootJ]) {
                parent[rootI] = rootJ;
                size[rootJ] += size[rootI];
                maxSize = Math.max(maxSize, size[rootJ]);
            } else {
                parent[rootJ] = rootI;
                size[rootI] += size[rootJ];
                maxSize = Math.max(maxSize, size[rootI]);
            }
        }
    }

    public int getMaxSize() {
        return this.maxSize;
    }
}
