package com.catxu.leetcode.question212;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<String>();
        for (String word : words) {
            dfs(ans, board, word, "", 0, 0);
        }
        return ans;
    }

    private void dfs(List<String> ans, char[][] board, String word, String state, int row, int col) {
        if (state.length() == word.length()) {
            ans.add(word);
            return;
        }
        for (int i = row; i < board.length; i++) {
            for (int j = col; j < board[i].length; j++) {
                if (board[i][j] != word.charAt(state.length())) {
                    continue;
                }
                state += board[i][j];
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(("".length()));
    }
}
