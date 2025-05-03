package com.catxu.leetcode.question37;

import java.util.ArrayList;
import java.util.List;

/**
 * 37. Sudoku Solver
 */
class Solution {
    private final List<int[]> spaces = new ArrayList<>();
    boolean[][] rows = new boolean[9][9];
    boolean[][] cols = new boolean[9][9];
    boolean[][][] subBoxes = new boolean[3][3][9];
    boolean valid = false;

    public void solveSudoku(char[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') {
                    int index = board[i][j] - '0' - 1; // 将value对应的坐标设置为 true
                    rows[i][index] = true;
                    cols[j][index] = true;
                    subBoxes[i / 3][j / 3][index] = true;
                } else {
                    spaces.add(new int[]{i, j});
                }
            }
        }

        backtracking(board, 0);
    }

    private void backtracking(char[][] board, int pos) {
        if (pos == spaces.size()) {
            valid = true;
            return;
        }
        int[] spaceIndex = spaces.get(pos); // 还未填充value的坐标
        int i = spaceIndex[0], j = spaceIndex[1];
        for (int index = 0; index < 9; index++) {
            if (!valid && !rows[i][index] && !cols[j][index] && !subBoxes[i / 3][j / 3][index]) {
                rows[i][index] = true;
                cols[j][index] = true;
                subBoxes[i / 3][j / 3][index] = true;
                board[i][j] = Character.forDigit(index + 1, 10);
                backtracking(board, pos + 1);
                rows[i][index] = false;
                cols[j][index] = false;
                subBoxes[i / 3][j / 3][index] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        s.solveSudoku(board);
        System.out.println("---");

    }
}
