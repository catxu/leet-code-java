package com.catxu.leetcode.question257;

import com.catxu.leetcode.question.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 257. Binary Tree Paths
 */
class Solution {
    private final List<String> ans = new LinkedList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, new LinkedList<>());
        return ans;
    }

    private void dfs(TreeNode node, List<Integer> path) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            path.add(node.val);
            ans.add(pathToString(path));
            path.removeLast();
            return;
        }
        path.add(node.val);
        dfs(node.left, path);
        dfs(node.right, path);
        path.removeLast();
    }

    private String pathToString(List<Integer> path) {
        StringBuilder sb = new StringBuilder();
        for (Integer val : path) {
            sb.append(val).append("->");
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().binaryTreePaths(TreeNode.levelOrderBuildTree(new Integer[]{1, 2, 3, null, 5})));
    }
}
