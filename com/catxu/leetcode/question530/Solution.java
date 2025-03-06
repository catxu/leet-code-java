package com.catxu.leetcode.question530;

import com.catxu.leetcode.question.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 530. Minimum Absolute Difference in BST
 * <p>
 * Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.
 * <p>
 * Example 1:
 * <img src="./bst1.png" alt="bst1 image" />
 * <p>
 * Input: root = [4,2,6,1,3]
 * Output: 1
 * <p>
 * Example 2:
 * <img src="./bst2.png" alt="bst2 image" />
 * <p>
 * Input: root = [1,0,48,null,null,12,49]
 * Output: 1
 * <p>
 * Constraints:
 * <p>
 * · The number of nodes in the tree is in the range [2, 10<sup>4</sup>].
 * <p>
 * · 0 <= Node.val <= 10<sup>5</sup>
 * <p>
 * Note: This question is the same as 783: <a href="https://leetcode.com/problems/minimum-distance-between-bst-nodes/">783</a>
 */
class Solution {
    private int minDiff = Integer.MAX_VALUE;
    private int prev = -10_0000;

    public int getMinimumDifference(TreeNode root) {
        inOrderTraversal(root);
        return minDiff;
    }

    // 待优化 一次遍历 并计算 miniDiff
    private void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        minDiff = Math.min(minDiff, node.val - prev);
        prev = node.val;
        inOrderTraversal(node.right);
    }

    public static void main(String[] args) {
        TreeNode root1 = TreeNode.levelOrderBuildTree(new Integer[]{4, 2, 6, 1, 3});
        TreeNode root2 = TreeNode.levelOrderBuildTree(new Integer[]{1, 0, 48, null, null, 12, 49});

        System.out.println(new Solution().getMinimumDifference(root1));
        System.out.println(new Solution().getMinimumDifference(root2));

    }
}