package com.catxu.leetcode.question117;

/**
 *117. Populating Next Right Pointers in Each Node II
 */
class Solution {

    Node nextStart = null, last = null;

    public Node connect(Node root) {
        Node start = root;
        while (start != null) {
            nextStart = null;
            last = null;
            for (Node p = start; p != null; p = p.next) {
                if (p.left != null) {
                    handle(p.left);
                }
                if (p.right != null) {
                    handle(p.right);
                }
            }
            start = nextStart;
        }
        return root;
    }

    public void handle(Node node) {
        if (nextStart == null) {
            nextStart = node;
        }
        if (last != null) {
            last.next = node;
        }
        last = node;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

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
}
