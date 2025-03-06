package com.catxu.leetcode.question173;

import com.catxu.leetcode.question.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class BSTIterator {

    private Integer next;
    private final List<Integer> nodes;

    public BSTIterator(TreeNode root) {
        this.nodes = new ArrayList<>();
        inOrderInitNodes(root, nodes);
        this.next = 0;
    }

    private void inOrderInitNodes(TreeNode root, List<Integer> nodes) {
        if (root == null) {
            return;
        }
        inOrderInitNodes(root.left, nodes);
        nodes.add(root.val);
        inOrderInitNodes(root.right, nodes);
    }

    public int next() {
        return this.nodes.get(this.next++);
    }

    public boolean hasNext() {
        return this.next < this.nodes.size();
    }

    public static void main(String[] args) {
        BSTIterator iterator = new BSTIterator(TreeNode.levelOrderBuildTree(new Integer[]{7, 3, 15, null, null, 9, 20}));
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
    }
}

/*
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
