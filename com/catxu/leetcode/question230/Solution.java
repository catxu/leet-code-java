package com.catxu.leetcode.question230;

import com.catxu.leetcode.question.TreeNode;

/**
 * 230. Kth Smallest Element in a BST
 */
class Solution {

    private int count;
    private int target;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inOrder(root);
        return target;
    }

    private void inOrder(TreeNode root) {
        if (root == null || count <= 0) {
            return;
        }
        inOrder(root.left);
        count--;
        if (count == 0) {
            target = root.val;
            return;
        }
        inOrder(root.right);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().kthSmallest(TreeNode.levelOrderBuildTree(new Integer[]{3, 1, 4, null, 2, null, 0}), 1));
    }
}