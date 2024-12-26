package com.catxu.leetcode.question212;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 212. Word Search II
 * <p>
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 * <p>
 * Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 * <p>
 * Example 1:
 * <p>
 * Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
 * <p>
 * Output: ["eat","oath"]
 * <p>
 * Example 2:
 * <p>
 * Input: board = [["a","b"],["c","d"]], words = ["abcb"]
 * <p>
 * Output: []
 * <p>
 * Constraints:
 * <p>
 * m == board.length
 * <p>
 * n == board[i].length
 * <p>
 * 1 <= m, n <= 12
 * <p>
 * board[i][j] is a lowercase English letter.
 * <p>
 * 1 <= words.length <= 3 * 10<sup>4</sup>
 * <p>
 * 1 <= words[i].length <= 10
 * <p>
 * words[i] consists of lowercase English letters.
 * <p>
 * All the strings of words are unique.
 */
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findWords(new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        }, new String[]{
                "oath", "pea", "eat", "rain", "et"
        }));
        System.out.println(solution.findWords(new char[][]{
                {'a', 'b'},
                {'c', 'd'}
        }, new String[]{
                "abcd"
        }));
        System.out.println(solution.findWords(new char[][]{
                {'a'}
        }, new String[]{
                "a"
        }));
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie node = new Trie();
        for (String word : words) {
            node.insert(word);
        }
        Set<String> ans = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, ans, node, i, j, "");
            }
        }
        return new ArrayList<>(ans);
    }

    private void dfs(char[][] board, Set<String> ans, Trie node, int i, int j, String state) {
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || board[i][j] == '#') {
            return;
        }
        char c = board[i][j];
        state += c;
        if (!node.startsWith(state)) {
            return;
        }
        if (!ans.contains(state) && node.search(state)) {
            ans.add(state);
        }
        // 标记当前节点
        board[i][j] = '#';
        // 搜索相邻节点
        dfs(board, ans, node, i - 1, j, state);
        dfs(board, ans, node, i + 1, j, state);
        dfs(board, ans, node, i, j - 1, state);
        dfs(board, ans, node, i, j + 1, state);
        // 恢复当前节点
        board[i][j] = c;
    }

    static class Trie {
        private final Trie[] child;
        private boolean isEndOfWord;

        public Trie() {
            child = new Trie[26];
            isEndOfWord = false;
        }

        public void insert(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int index = ch - 'a';
                if (node.child[index] == null) {
                    node.child[index] = new Trie();
                }
                node = node.child[index];
            }
            node.isEndOfWord = true;
        }

        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        public boolean search(String word) {
            Trie node = searchPrefix(word);
            return node != null && node.isEndOfWord;
        }

        private Trie searchPrefix(String prefix) {
            Trie node = this;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                int index = ch - 'a';
                if (node.child[index] == null) {
                    return null;
                }
                node = node.child[index];
            }
            return node;
        }
    }
}
