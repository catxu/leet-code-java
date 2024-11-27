package com.catxu.leetcode.question94;

import com.catxu.leetcode.question.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. Binary Tree Inorder Traversal
 * <p>
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * Example 1:
 * <p>
 * Input: root = [1,null,2,3]
 * <p>
 * Output: [1,3,2]
 * <p>
 * Explanation:
 * <p>
 * <img src="./ex1.png" alt="tree image" />
 * <p>
 * Example 2:
 * <p>
 * Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
 * <p>
 * Output: [4,2,6,5,7,1,3,9,8]
 * <p>
 * Explanation:
 * <p>
 * <img src="./ex2.png" alt="tree image" />
 * <p>
 * Example 3:
 * <p>
 * Input: root = []
 * <p>
 * Output: []
 * <p>
 * Example 4:
 * <p>
 * Input: root = [1]
 * <p>
 * Output: [1]
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 100].
 * <p>
 * -100 <= Node.val <= 100
 * <p>
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        return res;
    }

    private void inOrder(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        inOrder(node.left, res);
        res.add(node.val);
        inOrder(node.right, res);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.inorderTraversal(TreeNode.levelOrderBuildTree(new Integer[]{1, null, 2, 3})));
        System.out.println(solution.inorderTraversal(TreeNode.levelOrderBuildTree(new Integer[]{1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9})));
        System.out.println(solution.inorderTraversal(TreeNode.levelOrderBuildTree(new Integer[]{})));
        System.out.println(solution.inorderTraversal(TreeNode.levelOrderBuildTree(new Integer[]{1})));
    }
}
