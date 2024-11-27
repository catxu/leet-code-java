package com.catxu.leetcode.question;

public class AVLTreeNode extends TreeNode {
    private int height;
    public AVLTreeNode left;
    public AVLTreeNode right;

    public int getHeight(AVLTreeNode node) {
        // 叶节点高度为 0， native type int 默认为0
        return node == null ? -1 : node.height;
    }

    private void updateHeight(AVLTreeNode node) {
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    public int balanceFactor(AVLTreeNode node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    private AVLTreeNode rightRotate(AVLTreeNode node) {
        AVLTreeNode child = node.left;
        AVLTreeNode grandChild = child.right;
        child.right = node;
        node.left = grandChild;
        updateHeight(node);
        updateHeight(child);
        return child;
    }

    private AVLTreeNode leftRotate(AVLTreeNode node) {
        AVLTreeNode child = node.right;
        AVLTreeNode grandChild = child.left;
        child.left = node;
        node.right = grandChild;
        updateHeight(node);
        updateHeight(child);
        return child;
    }


}
