package com.catxu.leetcode.question59;

import java.util.Arrays;

/**
 * 59. Spiral Matrix II
 */
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int left = 0, right = n - 1;
        int top = 0, bottom = n - 1;
        int i = 1;
        while (i <= n * n) {
            for (int j = left; j <= right; j++) {
                matrix[top][j] = i++;
            }
            top++;
            for (int j = top; j <= bottom; j++) {
                matrix[j][right] = i++;
            }
            right--;
            for (int j = right; j >= left; j--) {
                matrix[bottom][j] = i++;
            }
            bottom--;
            for (int j = bottom; j >= top; j--) {
                matrix[j][left] = i++;
            }
            left++;
        }
        return matrix;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().generateMatrix(3)));
        System.out.println(Arrays.deepToString(new Solution().generateMatrix(2)));
        System.out.println(Arrays.deepToString(new Solution().generateMatrix(20)));
    }
}
