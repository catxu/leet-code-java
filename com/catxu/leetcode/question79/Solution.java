package com.catxu.leetcode.question79;

/**
 * 79. Word Search
 */
public class Solution {

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0, visited)) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int cur, boolean[][] visited) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(cur) || visited[i][j])
            return false;
        if (cur == word.length() - 1 && board[i][j] == word.charAt(cur)) return true;

        visited[i][j] = true;
        boolean res = dfs(board, word, i + 1, j, cur + 1, visited) ||
                dfs(board, word, i, j + 1, cur + 1, visited) ||
                dfs(board, word, i - 1, j, cur + 1, visited) ||
                dfs(board, word, i, j - 1, cur + 1, visited);
        visited[i][j] = false;
        return res;
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
