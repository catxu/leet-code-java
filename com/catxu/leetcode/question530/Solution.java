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
 * Note: This question is the same as 783: https://leetcode.com/problems/minimum-distance-between-bst-nodes/
 */
class Solution {
    public int getMinimumDifference(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        inOrderTraversal(root, nodes);
        int miniDiff = 10_000000;
        int prevNodeVal = nodes.get(0);
        for (int i = 1; i < nodes.size(); i++) {
            Integer val = nodes.get(i);
            miniDiff = Math.min(miniDiff, Math.abs(val - prevNodeVal));
            prevNodeVal = val;
        }
        return miniDiff;
    }

    // 待优化 一次遍历 并计算 miniDiff
    private void inOrderTraversal(TreeNode root, List<Integer> nodes) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left, nodes);
        nodes.add(root.val);
        inOrderTraversal(root.right, nodes);
    }

    public static void main(String[] args) {
        Integer[] levelorder1 = {4, 2, 6, 1, 3};  // 层序遍历数组
        TreeNode root1 = TreeNode.levelOrderBuildTree(levelorder1);
        // 打印树结构
        TreeNode.printTree(root1);

        Solution s = new Solution();
        System.out.println(s.getMinimumDifference(root1));

        Integer[] levelorder2 = {1, 0, 48, null, null, 12, 49};
        TreeNode root2 = TreeNode.levelOrderBuildTree(levelorder2);
        // 打印树结构
        TreeNode.printTree(root2);
        System.out.println(s.getMinimumDifference(root2));

    }
}