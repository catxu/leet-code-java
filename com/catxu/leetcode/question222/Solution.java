package com.catxu.leetcode.question222;

import com.catxu.leetcode.question.TreeNode;

/**
 * 222. Count Complete Binary Tree Nodes
 */
class Solution {
    public int countNodesRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + countNodesRecursive(root.left) + countNodesRecursive(root.right);
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if (leftHeight == rightHeight) { // 左子树是满二叉树
            // 1 << (leftHeight + 1)  等价于 Math.pow(2, leftHeight + 1)
            //  (1 << (leftHeight + 1)) - 1  计算满二叉树节点数的公式
            return (1 << leftHeight) + countNodes(root.right); // 1 + 左子树节点数 + 右子树节点数, 但左子树节点数直接用公式计算
        } else {
            return (1 << rightHeight) + countNodes(root.left);
        }
    }

    // 计算树的高度 (以左子树高度为准，因为完全二叉树的特性)
    private static int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int height = 0;
        while (node != null) {
            height++;
            node = node.left; // 一直向左子树遍历
        }
        return height;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countNodes(TreeNode.levelOrderBuildTree(new Integer[]{1, 2})));
        System.out.println(new Solution().countNodes(TreeNode.levelOrderBuildTree(new Integer[]{1, 2, 3, 4, 5, 6})));
        System.out.println(new Solution().countNodes(TreeNode.levelOrderBuildTree(new Integer[]{})));
    }
}
