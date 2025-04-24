package com.catxu.leetcode.question111;

import com.catxu.leetcode.question.TreeNode;

/**
 * 111. Minimum Depth of Binary Tree
 */
class Solution {
    public int minDepth(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        if (node.left != null && node.right == null) return dfs(node.left) + 1;
        if (node.right != null && node.left == null) return dfs(node.right) + 1;
        return Math.min(dfs(node.left), dfs(node.right)) + 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root1 = TreeNode.levelOrderBuildTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println(s.minDepth(root1));
        TreeNode root2 = TreeNode.levelOrderBuildTree(new Integer[]{2, null, 3, null, 4, null, 5, null, 6});
        System.out.println(s.minDepth(root2));
    }
}
