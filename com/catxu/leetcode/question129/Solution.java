package com.catxu.leetcode.question129;

import com.catxu.leetcode.question.TreeNode;

/**
 * 129. Sum Root to Leaf Numbers
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int i) {
        if (node == null) {
            return 0;
        }
        int sum = i * 10 + node.val;
        if (node.left == null && node.right == null) {
            return sum;
        }
        return dfs(node.left, sum) + dfs(node.right, sum);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().sumNumbers(TreeNode.levelOrderBuildTree(new Integer[]{1, 2, 3})));
    }
}
