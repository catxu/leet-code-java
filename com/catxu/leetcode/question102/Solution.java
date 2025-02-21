package com.catxu.leetcode.question102;

import com.catxu.leetcode.question.TreeNode;

import java.util.*;

/**
 * 102. Binary Tree Level Order Traversal
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        // 用于存放当前层的所有节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> res = new ArrayList<>();
            // 遍历当前层的所有节点
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                if (current != null) {
                    res.add(current.val);
                    queue.offer(current.left);
                    queue.offer(current.right);
                }
            }
            if (!res.isEmpty()) {
                ans.add(new ArrayList<>(res));
            }
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
    }
}
