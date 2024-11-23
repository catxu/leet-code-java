package com.catxu.leetcode.question114;

import com.catxu.leetcode.question.TreeNode;

/**
 * 114. Flatten Binary Tree to Linked List
 * <p>
 * Given the root of a binary tree, flatten the tree into a "linked list":
 * <p>
 * The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
 * <p>
 * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 * <p>
 * Example 1:
 * <p>
 * <img src="./flatten.png" alt="tree image" />
 * <p>
 * Input: root = [1,2,5,3,4,null,6]
 * <p>
 * Output: [1,null,2,null,3,null,4,null,5,null,6]
 * <p>
 * Example 2:
 * <p>
 * Input: root = []
 * <p>
 * Output: []'
 * <p>
 * Example 3:
 * <p>
 * Input: root = [0]
 * <p>
 * Output: [0]
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 2000].
 * <p>
 * -100 <= Node.val <= 100
 * <p>
 * Follow up: Can you flatten the tree in-place (with O(1) extra space)?
 */
class Solution {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);

        TreeNode origRightSubTree = root.right;
        root.right = root.left;
        root.left = null;

        TreeNode current = root;
        while (current.right != null)
            current = current.right;

        current.right = origRightSubTree;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root1 = TreeNode.levelOrderBuildTree(new Integer[]{1, 2, 5, 3, 4, null, 6});
        solution.flatten(root1);
        TreeNode.printTree(root1);

        TreeNode root2 = TreeNode.levelOrderBuildTree(new Integer[]{});
        solution.flatten(root2);
        TreeNode.printTree(root2);

        TreeNode root3 = TreeNode.levelOrderBuildTree(new Integer[]{0});
        solution.flatten(root3);
        TreeNode.printTree(root3);
    }


}
