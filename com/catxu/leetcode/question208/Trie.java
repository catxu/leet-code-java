package com.catxu.leetcode.question208;

import com.catxu.leetcode.question.TrieNode;

/**
 * 208. Implement Trie (Prefix Tree)
 * <p>
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
 * <p>
 * Implement the Trie class:
 * <p>
 * Trie() Initializes the trie object.
 * <p>
 * void insert(String word) Inserts the string word into the trie.
 * <p>
 * boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
 * <p>
 * boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 * <p>
 * Example 1:
 * <p>
 * Input
 * <p>
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * <p>
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * <p>
 * Output
 * <p>
 * [null, null, true, false, true, null, true]
 * <p>
 * Explanation
 *
 * <pre>
 *     {@code
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // return True
 * trie.search("app");     // return False
 * trie.startsWith("app"); // return True
 * trie.insert("app");
 * trie.search("app");     // return True
 *     }
 *
 * </pre>
 * Constraints:
 * <pre>
 * 1 <= word.length, prefix.length <= 2000
 * word and prefix consist only of lowercase English letters.
 * At most 3 * 10<sup>4</sup> calls in total will be made to insert, search, and startsWith.
 * </pre>
 */
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
