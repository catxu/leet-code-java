package com.catxu.leetcode.question52;

/**
 * 52. N-Queens II
 * <p>
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 * <p>
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 * <p>
 * Example 1:
 * <p>
 * <img src="./queens.png" />
 * <p>
 * Input: n = 4
 * <p>
 * Output: 2
 * <p>
 * Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
 * <p>
 * Example 2:
 * <p>
 * Input: n = 1
 * <p>
 * Output: 1
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 9
 */
class Solution {
    public int totalNQueens(int n) {
        return backtrack(n, 0, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1]);
    }

    private int backtrack(int n, int row, boolean[] cols, boolean[] mainDiag, boolean[] subDiag) {
        if (row == n) {
            return 1;
        }
        int ans = 0;
        for (int col = 0; col < n; col++) {
            int mainDiagIdx = row - col + n - 1;
            int subDiagIdx = row + col;
            if (!cols[col] && !mainDiag[mainDiagIdx] && !subDiag[subDiagIdx]) {
                // make choice
                cols[col] = mainDiag[mainDiagIdx] = subDiag[subDiagIdx] = true;
                ans += backtrack(n, row + 1, cols, mainDiag, subDiag);
                // withdraw choice
                cols[col] = mainDiag[mainDiagIdx] = subDiag[subDiagIdx] = false;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.totalNQueens(8));
        System.out.println(s.totalNQueens(1));
    }
}
