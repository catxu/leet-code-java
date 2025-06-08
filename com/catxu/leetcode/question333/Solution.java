package com.catxu.leetcode.question333;

import com.catxu.leetcode.question.TreeNode;

/**
 * 333. Largest BST Subtree
 */
class Solution {
    private int ans = 0;

    public int largestBSTSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int[] dfs(TreeNode node) {
        if (node == null) return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0}; // 最小值/最大值/当前bstSize
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        if (left[1] < node.val && node.val < right[0]) {
            int curBSTSize = left[2] + right[2] + 1;
            ans = Math.max(ans, curBSTSize);
            return new int[]{Math.min(left[0], node.val), Math.max(right[1], node.val), curBSTSize};
        }
        return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.levelOrderBuildTree(new Integer[]{3, 1, 4, 2});
        System.out.println(new Solution().largestBSTSubtree(root));
    }
}
