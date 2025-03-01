package com.catxu.leetcode.question112;

import com.catxu.leetcode.question.TreeNode;

/**
 * 112. Path Sum
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return dfs(root, 0, targetSum);
    }

    private boolean dfs(TreeNode root, int res, int targetSum) {
        if (root == null) {
            return false;
        }
        res += root.val;
        if (res == targetSum && root.left == null && root.right == null) {
            return true;
        }
        return dfs(root.left, res, targetSum) || dfs(root.right, res, targetSum);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().hasPathSum(TreeNode.levelOrderBuildTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1}), 22));
        System.out.println(new Solution().hasPathSum(TreeNode.levelOrderBuildTree(new Integer[]{1, 2, 3}), 5));
        System.out.println(new Solution().hasPathSum(TreeNode.levelOrderBuildTree(new Integer[]{}), 0));
        System.out.println(new Solution().hasPathSum(TreeNode.levelOrderBuildTree(new Integer[]{-2, null, -3}), -5));
    }
}
