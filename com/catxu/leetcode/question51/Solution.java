package com.catxu.leetcode.question51;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 51. N-Queens
 * <p>
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 * <p>
 * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
 * <p>
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
 * <p>
 * Example 1:
 * <p>
 * <img src="./queens.png">
 * <p>
 * Input: n = 4
 * <p>
 * Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * <p>
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
 * <p>
 * Example 2:
 * <p>
 * Input: n = 1
 * <p>
 * Output: [["Q"]]
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 9
 */
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        boolean[] cols = new boolean[n];
        boolean[] mainDiag = new boolean[2 * n - 1];
        boolean[] subDiag = new boolean[2 * n - 1];
        List<List<String>> state = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(".");
            }
            state.add(row);
        }
        backtracking(res, state, 0, n, cols, mainDiag, subDiag);
        return res;
    }

    private void backtracking(List<List<String>> res, List<List<String>> state, int row, int n, boolean[] cols, boolean[] mainDiag, boolean[] subDiag) {
        if (row == n) {
            // 将state 里面每一行（List<String>）即 [".","Q",".","."] 转成 [".Q..", "...Q", ...] 的格式，以满足题目返回要求
            List<String> chessBoard = state.stream().map(e -> String.join("", e)).toList();
            res.add(chessBoard);
            return;
        }
        List<String> chessRow = state.get(row);
        // 循环遍历当前行的所有列
        for (int col = 0; col < n; col++) {
            int mainDiagIdx = row - col + n - 1;
            int subDiagIdx = row + col;
            if (!cols[col] && !mainDiag[mainDiagIdx] && !subDiag[subDiagIdx]) {
                chessRow.set(col, "Q");
                cols[col] = mainDiag[mainDiagIdx] = subDiag[subDiagIdx] = true;
                // 回溯遍历所有行
                backtracking(res, state, row + 1, n, cols, mainDiag, subDiag);
                chessRow.set(col, ".");
                cols[col] = mainDiag[mainDiagIdx] = subDiag[subDiagIdx] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solveNQueens(4));
        System.out.println(s.solveNQueens(1));
    }
}