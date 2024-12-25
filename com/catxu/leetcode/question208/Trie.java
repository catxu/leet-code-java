package com.catxu.leetcode.question208;

import com.catxu.leetcode.question.TrieNode;

class Trie {
    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // 插入一个单词
    public void insert(String word) {
        TrieNode currentNode = root;
        for (char c : word.toCharArray()) {
            currentNode = currentNode.children.computeIfAbsent(c, k -> new TrieNode());
        }
        currentNode.isEndOfWord = true;
    }

    // 查找一个单词
    public boolean search(String word) {
        TrieNode currentNode = root;
        for (char c : word.toCharArray()) {
            currentNode = currentNode.children.get(c);
            if (currentNode == null) {
                return false;
            }
        }
        return currentNode.isEndOfWord;
    }

    // 判断是否存在以某个前缀开头的单词
    public boolean startsWith(String prefix) {
        TrieNode currentNode = root;
        for (char c : prefix.toCharArray()) {
            currentNode = currentNode.children.get(c);
            if (currentNode == null) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("cat");
        trie.insert("dog");
        System.out.println(trie.search("dog"));
        System.out.println(trie.startsWith("dog"));
        System.out.println(trie.startsWith("a"));
        System.out.println(trie.startsWith("c"));
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
