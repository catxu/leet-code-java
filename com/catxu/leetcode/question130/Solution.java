package com.catxu.leetcode.question130;

import java.util.Arrays;

/**
 * 130. Surrounded Regions
 */
class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        // 查找[上下左右]4个边界是否存在'O'
        for (int i = 0; i < m; i++) {
            infect(board, i, 0); // 左边界
            infect(board, i, n - 1); // 右边界
        }
        for (int j = 0; j < n; j++) {
            infect(board, 0, j); // 上边界
            infect(board, m - 1, j); // 下边界
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void infect(char[][] board, int m, int n) {
        if (m < 0 || n < 0 || m >= board.length || n >= board[0].length) {
            return;
        }
        if (board[m][n] != 'O') {
            return;
        }
        //protect pos
        board[m][n] = '#';
        infect(board, m - 1, n);
        infect(board, m + 1, n);
        infect(board, m, n + 1);
        infect(board, m, n - 1);
    }

    public static void main(String[] args) {
        char[][] board1 = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        new Solution().solve(board1);
        System.out.println(Arrays.deepToString(board1));
        char[][] board2 = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'O', 'X'}
        };
        new Solution().solve(board2);
        System.out.println(Arrays.deepToString(board2));
    }
}