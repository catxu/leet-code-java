package com.catxu.leetcode.question73;

import java.util.Arrays;

/**
 * 73. Set Matrix Zeroes
 * <p>
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
 * <p>
 * You must do it in place.
 * <p>
 * Example 1:
 * <pre>
 * <img src="./mat1.png" />
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 * </pre>
 * Example 2:
 * <pre>
 * <img src="./mat2.png" />
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 * </pre>
 * Constraints:
 * <pre>
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -2<sup>31</sup> <= matrix[i][j] <= 2<sup>31</sup> - 1
 * </pre>
 * Follow up:
 * <p>
 * A straightforward solution using O(mn) space is probably a bad idea.
 * <p>
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * <p>
 * Could you devise a constant space solution?
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length; // 行
        int n = matrix[0].length;
        boolean firstRowZero = false, firstColZero = false;
        // 判断首行是否为 0
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                firstRowZero = true;
                break;
            }
        }
        // 判断首列是否为 0
        for (int j = 0; j < m; j++) {
            if (matrix[j][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // 标记 [i][j]所在的首行与首列
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        // 根据首行、首列标记填充[i][j]
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 处理 首行与首列
        if (firstRowZero) {
            Arrays.fill(matrix[0], 0);
        }
        if (firstColZero) {
            for (int j = 0; j < m; j++) {
                matrix[j][0] = 0;
            }
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix1 = new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        solution.setZeroes(matrix1);

        int[][] matrix2 = new int[][]{
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        solution.setZeroes(matrix2);

        int[][] matrix3 = new int[][]{
                {1}
        };
        solution.setZeroes(matrix3);

        System.out.println(Arrays.deepToString(matrix1));
        System.out.println(Arrays.deepToString(matrix2));
        System.out.println(Arrays.deepToString(matrix3));
    }
}
