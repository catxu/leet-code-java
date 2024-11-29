package com.catxu.leetcode.question;

public class AVLTreeNode extends TreeNode {
    private int height;
    public AVLTreeNode left;
    public AVLTreeNode right;
    private AVLTreeNode root;

    public AVLTreeNode(int val) {
        super(val);
    }

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

    private AVLTreeNode rotate(AVLTreeNode node) {
        int balanceFactor = balanceFactor(node);
        // 左偏树
        if (balanceFactor > 1) {
            if (balanceFactor(node.left) >= 0) {
                return rightRotate(node);
            } else {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        } else if (balanceFactor < -1) {
            // 右偏树
            if (balanceFactor(node.right) <= 0) {
                return leftRotate(node);
            } else {
                // 先右旋 再左旋
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        } else {
            return node;
        }
    }

    // 只能在根节点执行插入
    public void insert(int val) {
        root = insertHelper(root, val);
    }

    private AVLTreeNode insertHelper(AVLTreeNode node, int val) {
        if (node == null) {
            return new AVLTreeNode(val);
        }
        if (val < node.val) {
            node.left = insertHelper(node.left, val);
        } else if (val > node.val) {
            node.right = insertHelper(node.right, val);
        } else {
            return node;
        }
        updateHeight(node);
        node = rotate(node);
        return node;
    }

    // 从根节点进行remove
    public void remove(int val) {
        root = removeHelper(root, val);
    }

    private AVLTreeNode removeHelper(AVLTreeNode node, int val) {
        if (node == null) {
            return null;
        }
        if (val < node.val) {
            node.left = removeHelper(node.left, val);
        } else if (val > node.val) {
            node.right = removeHelper(node.right, val);
        } else {
            if (node.left == null || node.right == null) {
                AVLTreeNode child = node.left != null ? node.left : node.right;
                // 子节点数量为 0，直接删除node并返回
                if (child == null) {
                    return null;
                } else {
                    // 子节点数量为 1，直接删除node
                    node = child;
                }
            } else {
                // 子节点数量为 2，则将中序遍历的下个节点删除，并用该节点替换当前节点
                AVLTreeNode temp = node.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                node.right = removeHelper(node.right, temp.val);
                node.val = temp.val;
            }
        }
        updateHeight(node);
        node = rotate(node);
        return node;
    }

}
