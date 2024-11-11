package com.catxu.leetcode.question104;

import com.catxu.leetcode.question.TreeNode;

/**
 * 104. Maximum Depth of Binary Tree
 * <p>
 * Given the root of a binary tree, return its maximum depth.
 * <p>
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p>
 * Example 1:
 * <img src="./tmp-tree.jpg" alt="tree image" />
 * <p>
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * <p>
 * Example 2:
 * <p>
 * Input: root = [1,null,2]
 * Output: 2
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 10^4].
 * -100 <= Node.val <= 100
 */
class Solution {
    public int maxDepth(TreeNode root) {
        return backtracking(root, 0);
    }

    private int backtracking(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        depth++;
        int leftDepth = backtracking(root.left, depth);
        int rightDepth = backtracking(root.right, depth);
        return Math.max(leftDepth, rightDepth);
    }

    public static void main(String[] args) {
        TreeNode root1 = TreeNode.levelOrderBuildTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        Solution solution = new Solution();
        System.out.println(solution.maxDepth(root1));
        TreeNode root2 = TreeNode.levelOrderBuildTree(new Integer[]{1, null, 2});
        System.out.println(solution.maxDepth(root2));
    }
}