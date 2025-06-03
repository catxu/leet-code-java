package com.catxu.leetcode.question110;

import com.catxu.leetcode.question.TreeNode;

/**
 * 110. Balanced Binary Tree
 * <p>
 * Given a binary tree, determine if it is height-balanced.
 * <p>
 * Example 1:
 * <p>
 * <img src="./balance_1.png" alt="tree image" />
 * <p>
 * Input: root = [3,9,20,null,null,15,7]
 * <p>
 * Output: true
 * <p>
 * Example 2:
 * <pre>
 * <img src="./balance_2.png" alt="tree image" />
 * Input: root = [1,2,2,3,3,null,null,4,4]
 * Output: false
 * </pre>
 * Example 3:
 * <pre>
 * Input: root = []
 * Output: true
 * </pre>
 * Constraints:
 * <pre>
 * The number of nodes in the tree is in the range [0, 5000].
 * -10<sup>4</sup> <= Node.val <= 10<sup>4</sup>
 * </pre>
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    private boolean isBalanced = true;

    public boolean isBalancedII(TreeNode root) {
        if (root == null) {
            return true;
        }
        int l = getHeight(root.left);
        int r = 0;
        if (isBalanced) r = getHeight(root.right);
        return isBalanced && Math.abs(l - r) <= 1;
    }

    private int getHeight(TreeNode node) {
        if (node == null) return 0;
        int l = getHeight(node.left) + 1;
        int r = getHeight(node.right) + 1;
        if (Math.abs(l - r) > 1) isBalanced = false;
        return Math.max(l, r);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isBalanced(TreeNode.levelOrderBuildTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
        System.out.println(solution.isBalanced(TreeNode.levelOrderBuildTree(new Integer[]{1, 2, 2, 3, 3, null, null, 4, 4})));
        System.out.println(solution.isBalanced(TreeNode.levelOrderBuildTree(new Integer[]{})));
        System.out.println(solution.isBalanced(TreeNode.levelOrderBuildTree(new Integer[]{1, 2, 2, 3, null, null, 3, 4, null, null, 4})));
        System.out.println(solution.isBalancedII(TreeNode.levelOrderBuildTree(new Integer[]{1, 2, 2, 3, null, null, 3, 4, null, null, 4})));

        TreeNode.printTree(TreeNode.levelOrderBuildTree(new Integer[]{1, 2, 2, 3, null, null, 3, 4, null, null, 4}));
    }
}
