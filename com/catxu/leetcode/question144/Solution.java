package com.catxu.leetcode.question144;

import com.catxu.leetcode.question.TreeNode;

import java.util.*;

/**
 * 144. Binary Tree Preorder Traversal
 */
class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) return ans;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().preorderTraversal(TreeNode.levelOrderBuildTree(new Integer[]{1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9})));
    }
}
