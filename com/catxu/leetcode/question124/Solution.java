package com.catxu.leetcode.question124;

import com.catxu.leetcode.question.TreeNode;

/**
 * 124. Binary Tree Maximum Path Sum
 */
class Solution {
    private int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        left = Math.max(left, 0);
        right = Math.max(right, 0);
        ans = Math.max(ans, node.val + left + right); // 不遗漏不重复
        return node.val + Math.max(left, right);
    }


    public static void main(String[] args) {
        System.out.println(new Solution().maxPathSum(TreeNode.levelOrderBuildTree(new Integer[]{-11, 2, 3})));
    }
}
