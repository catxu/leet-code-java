package com.catxu.leetcode.question226;

import com.catxu.leetcode.question.TreeNode;

/**
 * 226. Revert Binary Tree
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = solution.invertTree(TreeNode.levelOrderBuildTree(new Integer[]{1,2}));
        TreeNode.printTree(root);
    }
}
