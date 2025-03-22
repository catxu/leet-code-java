package com.catxu.leetcode.question427;

/**
 * 427. Construct Quad Tree
 */
class Solution {
    public Node construct(int[][] grid) {
        return dfs(grid, 0, 0, grid.length, grid.length);
    }

    private Node dfs(int[][] grid, int rowStart, int colStart, int rowEnd, int colEnd) {
        boolean allSame = true;
        for (int i = rowStart; i < rowEnd; i++) {
            if (!allSame) {
                break;
            }
            for (int j = colStart; j < colEnd; j++) {
                if (grid[rowStart][colStart] != grid[i][j]) {
                    allSame = false;
                    break;
                }
            }
        }
        if (allSame) {
            return new Node(grid[rowStart][colStart] == 1, true);
        }
        Node topLeft = dfs(grid, rowStart, colStart, (rowStart + rowEnd) / 2, (colStart + colEnd) / 2);
        Node topRight = dfs(grid, rowStart, (colStart + colEnd) / 2, (rowStart + rowEnd) / 2, colEnd);
        Node bottomLeft = dfs(grid, (rowStart + rowEnd) / 2, colStart, rowEnd, (colStart + colEnd) / 2);
        Node bottomRight = dfs(grid, (rowStart + rowEnd) / 2, (colStart + colEnd) / 2, rowEnd, colEnd);
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    // Definition for a QuadTree node.
    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
}
