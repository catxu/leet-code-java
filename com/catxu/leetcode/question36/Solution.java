package com.catxu.leetcode.question36;

/**
 * 36. Valid Sudoku
 * <p>
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 * <p>
 * Each row must contain the digits 1-9 without repetition.
 * <p>
 * Each column must contain the digits 1-9 without repetition.
 * <p>
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * <p>
 * Note:
 * <p>
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * <p>
 * Only the filled cells need to be validated according to the mentioned rules.
 * <p>
 * Example 1:
 * <p>
 * Input: board =
 * <pre>
 * {@code
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * }
 * </pre>
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: board =
 * <pre>
 * {@code
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * }
 * </pre>
 * Output: false
 * <p>
 * Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8.
 * <p>
 * Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 * <p>
 * Constraints:
 * <pre>
 * board.length == 9
 * board[i].length == 9
 * board[i][j] is a digit 1-9 or '.'
 * </pre>
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length, n = board[0].length;
        int[][] rows = new int[m][m];
        int[][] cols = new int[n][n];
        int[][][] subBoxes = new int[3][3][9];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') {
                    int index = board[i][j] - '0' - 1;
                    if (++rows[i][index] > 1 || ++cols[j][index] > 1 || ++subBoxes[i / 3][j / 3][index] > 1)
                        return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isValidSudoku(new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}}));
        System.out.println(s.isValidSudoku(new char[][]{{'8', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}}));
    }
}
