package com.catxu.leetcode.question98;

import com.catxu.leetcode.question.TreeNode;

/**
 * 98. Validate Binary Search Tree
 */
class Solution {
    private boolean valid = true;
    private Integer prev = null;

    public boolean isValidBST(TreeNode root) {
        dfs(root);
        return valid;
    }

    private void dfs(TreeNode node) {
        if (node == null || !valid) {
            return;
        }
        dfs(node.left);
        if (prev == null) {
            prev = node.val;
        } else {
            if (node.val <= prev) {
                valid = false;
                return;
            } else {
                prev = node.val;
            }
        }
        dfs(node.right);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValidBST(TreeNode.levelOrderBuildTree(new Integer[]{2, 1, 3})));
        System.out.println(new Solution().isValidBST(TreeNode.levelOrderBuildTree(new Integer[]{5, 1, 4, null, null, 3, 6})));
    }
}