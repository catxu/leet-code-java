package com.catxu.leetcode.question116;

import java.util.ArrayList;
import java.util.List;

/**
 * 116. Populating Next Right Pointers in Each Node
 */
class Solution {
    // Definition for a Node.
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    List<Node> prev = new ArrayList<>(12);

    public Node connect(Node root) {
        dfs(root, 0);
        return root;
    }

    private void dfs(Node node, int level) {
        if (node == null) return;
        if (prev.size() == level) { // 前序遍历构造每层头节点
            prev.add(node);
        } else { // 回溯通过level取回前驱节点，构造 next指针
            prev.get(level).next = node;
            prev.set(level, node);
        }
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}
