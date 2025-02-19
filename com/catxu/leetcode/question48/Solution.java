package com.catxu.leetcode.question48;

import java.util.Arrays;

/**
 * 48. Rotate Image
 * <pre>
 * [1,2,3]
 * [4,5,6]
 * [7,8,9]
 * </pre>
 * <pre>
 * [7,4,1]
 * [8,5,2]
 * [9,6,3]
 * </pre>
 */
class Solution {
    // 第 i 行 -> 第 n - 1 - i 列
    // 第 j 列 -> 第 j 行
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] copy = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(matrix[i], 0, copy[i], 0, n);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[j][n - 1 - i] = copy[i][j];
            }
        }
    }

    public void rotateInPlace(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix1 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new Solution().rotate(matrix1);
        int[][] matrix2 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new Solution().rotateInPlace(matrix2);
        System.out.println(Arrays.deepToString(matrix1));
        System.out.println(Arrays.deepToString(matrix2));
    }
}
