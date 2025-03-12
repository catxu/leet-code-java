package com.catxu.leetcode.question289;

import java.util.Arrays;

/**
 * 289. Game of Life
 */
class Solution {

    /* truth table
        0 : 0 -> 0
        1 : 0 -> 1
        0 : 1 -> 2
        1 : 1 -> 3
     */
    private static final int DEAD_DEAD = 0;
    private static final int LIVE_DEAD = 1;
    private static final int DEAD_LIVE = 2;
    private static final int LIVE_LIVE = 3;

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveCnt = countNeighbors(board, i, j, m, n);
                if (board[i][j] == 1) {
                    if (liveCnt == 2 || liveCnt == 3) {
                        board[i][j] = LIVE_LIVE;
                    }
                } else if (liveCnt == 3) {
                    board[i][j] = DEAD_LIVE;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == LIVE_DEAD) {
                    board[i][j] = 0;
                } else if (board[i][j] == DEAD_LIVE || board[i][j] == LIVE_LIVE) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private static int countNeighbors(int[][] board, int i, int j, int m, int n) {
        int count = 0;
        for (int r = i - 1; r < i + 2; r++) {
            for (int c = j - 1; c < j + 2; c++) {
                if ((r == i && c == j) || r < 0 || c < 0
                        || r >= m || c >= n) {
                    continue;
                }
                if (board[r][c] == LIVE_DEAD || board[r][c] == LIVE_LIVE) {
                    // original alive
                    count += 1;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] board0 = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        new Solution().gameOfLife(board0);
        System.out.println(Arrays.deepToString(board0));
        int[][] board1 = {{1, 1}, {1, 0}};
        new Solution().gameOfLife(board1);
        System.out.println(Arrays.deepToString(board1));
    }
}
