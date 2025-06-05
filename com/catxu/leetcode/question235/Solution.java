package com.catxu.leetcode.question235;

import com.catxu.leetcode.question.TreeNode;

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 利用bst性质，如果p/q小于当前节点，搜索左子树
        // 想想为什么没有返回null的base case判断？因为只有当p、q都在同一侧子树时，且dfs却遍历了相反的子树，才会出现root为null的情况
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}
