package com.catxu.leetcode.question199;

import com.catxu.leetcode.question.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199. Binary Tree Right Side View
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            Integer rightMost = null;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    queue.offer(node.left);
                    queue.offer(node.right);
                    rightMost = node.val;
                }
                if (rightMost != null && i == levelSize - 1) {
                    ans.add(rightMost);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().rightSideView(TreeNode.levelOrderBuildTree(new Integer[]{1, 2, 3, null, 5, null, 4})));
        System.out.println(new Solution().rightSideView(TreeNode.levelOrderBuildTree(new Integer[]{1, 2, 3, 4, null, null, null, 5})));
        System.out.println(new Solution().rightSideView(TreeNode.levelOrderBuildTree(new Integer[]{1, null, 3})));
        System.out.println(new Solution().rightSideView(TreeNode.levelOrderBuildTree(new Integer[]{})));
    }

}
