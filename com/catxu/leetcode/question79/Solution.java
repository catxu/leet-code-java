package com.catxu.leetcode.question79;

/**
 * 79. Word Search
 */
class Solution {
    private boolean result = false;

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(board, i, j, word, new StringBuilder(), visited);
                if (result) {
                    return true;
                }
            }
        }
        return result;
    }

    private void dfs(char[][] board, int row, int col, String word, StringBuilder state, boolean[][] visited) {
        if (!state.isEmpty() && !word.startsWith(state.toString())) {
            return;
        }
        if (state.length() == word.length() && state.toString().equals(word)) {
            result = true;
            return;
        }
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        state.append(board[row][col]);
        dfs(board, row - 1, col, word, state, visited);
        dfs(board, row, col - 1, word, state, visited);
        dfs(board, row + 1, col, word, state, visited);
        dfs(board, row, col + 1, word, state, visited);
        state.deleteCharAt(state.length() - 1);
        visited[row][col] = false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'},
        }, "ABCCED"));
        System.out.println(new Solution().exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'},
        }, "SEE"));
        System.out.println(new Solution().exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'},
        }, "ABCD"));
        System.out.println(new Solution().exist(new char[][]{
                {'A'}
        }, "A"));
    }
}
