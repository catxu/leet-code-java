package com.catxu.leetcode.question;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    // 表示是否是一个单词的结尾
    public boolean isEndOfWord;
    // 子节点映射
    public Map<Character, TrieNode> children;

    public TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}
