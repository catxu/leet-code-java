package com.catxu.leetcode.question272;

import com.catxu.leetcode.question.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 272. Closest Binary Search Tree Value II 🔒
 */
class Solution {

    private List<Integer> ans;
    private double target;
    private int k;

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        this.ans = new LinkedList<>();
        this.target = target;
        this.k = k;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        if (ans.size() < k) {
            ans.add(node.val);
        } else {
            if (Math.abs(node.val - target) >= Math.abs(ans.getFirst() - target)) {
                return;
            }
            ans.removeFirst();
            ans.add(node.val);
        }
        dfs(node.right);
    }
}
