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
 * <pre>
 * <img src="./tmp-tree.png" alt="tree image" />
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * </pre>
 * Example 2:
 * <pre>
 * Input: root = [1,null,2]
 * Output: 2
 * </pre>
 * <p>
 * Constraints:
 * <pre>
 * The number of nodes in the tree is in the range [0, 10<sup>4</sup>].
 * -100 <= Node.val <= 100
 * </pre>
 */
class Solution {
    public int maxDepth(TreeNode root) {
        // return dfs(root, 0);
        return dfs(root);
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left) + 1;
        int right = dfs(node.right) + 1;
        return Math.max(left, right);
    }


    // private int dfs(TreeNode root, int depth) {
    //     if (root == null) {
    //         return depth;
    //     }
    //     depth++;
    //     int leftDepth = dfs(root.left, depth);
    //     int rightDepth = dfs(root.right, depth);
    //     return Math.max(leftDepth, rightDepth);
    // }

    public static void main(String[] args) {
        TreeNode root1 = TreeNode.levelOrderBuildTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        Solution solution = new Solution();
        System.out.println(solution.maxDepth(root1));
        TreeNode root2 = TreeNode.levelOrderBuildTree(new Integer[]{1, null, 2});
        System.out.println(solution.maxDepth(root2));
    }
}