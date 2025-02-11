package com.catxu.leetcode.question54;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        int total = matrix.length * matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        int i = 1;
        while (i <= total) {
            for (int j = left; j <= right; j++) {
                ans.add(matrix[top][j]);
                i++;
            }
            if (i > total) {
                break;
            }

            top++;
            for (int j = top; j <= bottom; j++) {
                ans.add(matrix[j][right]);
                i++;
            }
            if (i > total) {
                break;
            }

            right--;
            for (int j = right; j >= left; j--) {
                ans.add(matrix[bottom][j]);
                i++;
            }
            if (i > total) {
                break;
            }

            bottom--;
            for (int j = bottom; j >= top; j--) {
                ans.add(matrix[j][left]);
                i++;
            }
            left++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println(new Solution().spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
    }
}
