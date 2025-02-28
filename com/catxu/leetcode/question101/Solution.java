package com.catxu.leetcode.question101;

import com.catxu.leetcode.question.TreeNode;

/**
 * 101. Symmetric Tree
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        } else {
            return dfs(left.left, right.right) && dfs(left.right, right.left);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isSymmetric(TreeNode.levelOrderBuildTree(new Integer[]{1, 2, 2, 3, 4, 4, 3})));
        System.out.println(new Solution().isSymmetric(TreeNode.levelOrderBuildTree(new Integer[]{1, 2, 2, null, 3, null, 3})));
    }
}
