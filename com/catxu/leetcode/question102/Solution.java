package com.catxu.leetcode.question102;

import com.catxu.leetcode.question.TreeNode;

import java.util.*;

/**
 * 102. Binary Tree Level Order Traversal
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> levelNode = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelNode.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            ans.add(levelNode);
        }
        return ans;
    }

    public List<List<Integer>> levelOrderDfs(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    public void dfs(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null) return;
        if (level == result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        dfs(root.left, level + 1, result);
        dfs(root.right, level + 1, result);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().levelOrder(TreeNode.levelOrderBuildTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
        System.out.println(new Solution().levelOrder(TreeNode.levelOrderBuildTree(new Integer[]{1})));
        System.out.println(new Solution().levelOrder(TreeNode.levelOrderBuildTree(new Integer[]{})));
        System.out.println(new Solution().levelOrderDfs(TreeNode.levelOrderBuildTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
    }
}
