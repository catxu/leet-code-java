package com.catxu.leetcode.question103;

import com.catxu.leetcode.question.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        boolean zigzagFlag = true;
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> res = new ArrayList<>();
            if (zigzagFlag) {
                for (int i = 0; i < size; i++) {
                    TreeNode node = deque.pollFirst();
                    if (node != null) {
                        res.add(node.val);
                        if (node.left != null) {
                            deque.offerLast(node.left);
                        }
                        if (node.right != null) {
                            deque.offerLast(node.right);
                        }
                    }
                }
                zigzagFlag = false;
            } else {
                for (int i = 0; i < size; i++) {
                    TreeNode node = deque.pollLast();
                    if (node != null) {
                        res.add(node.val);
                        if (node.right != null) {
                            deque.offerFirst(node.right);
                        }
                        if (node.left != null) {
                            deque.offerFirst(node.left);
                        }
                    }
                }
                zigzagFlag = true;
            }
            if (!res.isEmpty()) {
                ans.add(res);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().zigzagLevelOrder(TreeNode.levelOrderBuildTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
        System.out.println(new Solution().zigzagLevelOrder(TreeNode.levelOrderBuildTree(new Integer[]{1})));
        System.out.println(new Solution().zigzagLevelOrder(TreeNode.levelOrderBuildTree(new Integer[]{})));
    }
}
