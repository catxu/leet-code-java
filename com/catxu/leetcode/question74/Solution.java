package com.catxu.leetcode.question74;

/**
 * 74. Search a 2D Matrix
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        while (rowStart <= rowEnd) {
            int rowMid = (rowStart + rowEnd) / 2;
            if (target > matrix[rowMid][0]) {
                rowStart = rowMid + 1;
            } else if (target < matrix[rowMid][0]) {
                // 因为 target < matrix[rowMid][0] 保证了 target 必然在 rowEnd 行所在的列
                rowEnd = rowMid - 1;
            } else {
                return true;
            }
        }

        int colStart = 0;
        int colEnd = matrix[0].length - 1;
        while (rowEnd >= 0 && colStart <= colEnd) {
            int colMid = (colStart + colEnd) / 2;
            if (target > matrix[rowEnd][colMid]) {
                colStart = colMid + 1;
            } else if (target < matrix[rowEnd][colMid]) {
                colEnd = colMid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().searchMatrix(
                new int[][]{
                        {1, 3, 5, 7},
                        {10, 11, 16, 20},
                        {23, 30, 34, 60}
                }, 3));
        System.out.println(new Solution().searchMatrix(
                new int[][]{
                        {1, 3, 5, 7},
                        {10, 11, 16, 20},
                        {23, 30, 34, 60}
                }, 13));
        System.out.println(new Solution().searchMatrix(
                new int[][]{
                        {1}
                }, 1));

    }
}