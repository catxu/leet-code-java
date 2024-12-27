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

    static class TrieNode {
        String word;
        TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[26];
            word = null;
        }
    }

    private TrieNode root;

    // 构建 Trie
    public void buildTrie(String[] words) {
        root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.word = word; // 记录完整单词
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        // 结果集
        Set<String> result = new HashSet<>();
        // 构建 Trie
        buildTrie(words);

        // 遍历每个网格位置
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, result);
            }
        }

        return new ArrayList<>(result);
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, Set<String> result) {
        // 边界条件
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#') {
            return;
        }

        char c = board[i][j];
        int index = c - 'a';
        if (node.children[index] == null) {
            // 不在 Trie 中
            return;
        }

        node = node.children[index];
        if (node.word != null) {
            result.add(node.word); // 找到单词
            node.word = null; // 防止重复添加
        }

        // 标记当前节点
        board[i][j] = '#';

        // 搜索相邻节点
        dfs(board, i - 1, j, node, result);
        dfs(board, i + 1, j, node, result);
        dfs(board, i, j - 1, node, result);
        dfs(board, i, j + 1, node, result);

        // 恢复当前节点
        board[i][j] = c;
    }

}
