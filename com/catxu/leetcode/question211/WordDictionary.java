package com.catxu.leetcode.question211;

import java.util.HashMap;
import java.util.Map;

/**
 * 211. Design Add and Search Words Data Structure
 * <p>
 * Design a data structure that supports adding new words and finding if a string matches any previously added string.
 * <p>
 * Implement the WordDictionary class:
 * <p>
 * WordDictionary() Initializes the object.
 * <p>
 * void addWord(word) Adds word to the data structure, it can be matched later.
 * <p>
 * bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 */
class WordDictionary {

    static class TrieNode {
        private Map<Character, TrieNode> children;

        public TrieNode() {
            this.children = new HashMap<>();
        }
    }

    private TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        char[] chs = word.toCharArray();
        for (char ch : chs) {
            cur.children.computeIfAbsent(ch, k -> new TrieNode());
            cur = cur.children.get(ch);
        }
    }

    public boolean search(String word) {
        return search(word, root);
    }

    public boolean search(String word, TrieNode node) {
        if (word == null || word.isEmpty()) {
            return true;
        }
        TrieNode cur = node;
        char[] chs = word.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '.') {
                boolean res;
                for (int j = 'a'; j <= 'z'; j++) {
                    if (cur.children.get((char) j) != null) {
                        res = search(word.substring(i + 1), cur.children.get((char) j));
                        if (res) {
                            return true;
                        }
                    }
                }
                return false;
            }
            cur = cur.children.get(chs[i]);
            if (cur == null) {
                return false;
            }
        }
        return true;
    }

    // 假设问题中的通配符是类似“.”这样的单字符通配符，比如用户想搜索的模式中包含某个位置可以是任意字符。
    // 比如，“c.t”可以匹配“cat”或“cut”等。这种情况下，在字典树中进行搜索时，遇到通配符就需要遍历当前节点的所有子节点，继续搜索下去。
    // 如果是处理这种单字符通配符的情况，常规的深度优先搜索（DFS）或广度优先搜索（BFS）可能适用。
    // 例如，当在字典树的某个节点处理到通配符时，需要检查该节点的所有子节点，继续递归或迭代处理剩下的模式部分。
    public static void main(String[] args) {
        WordDictionary obj = new WordDictionary();
        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");
        System.out.println(obj.search("d.."));
        System.out.println(obj.search(".p.."));
        System.out.println(obj.search("badd"));
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
