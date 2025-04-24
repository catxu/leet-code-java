package com.catxu.leetcode.question543;

import com.catxu.leetcode.question.TreeNode;

/**
 * 543. Diameter of Binary Tree
 */
class Solution {
    private int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return -1;
        }
        int left = dfs(node.left) + 1;
        int right = dfs(node.right) + 1;
        ans = Math.max(ans, left + right);
        return Math.max(left, right);
    }
}
