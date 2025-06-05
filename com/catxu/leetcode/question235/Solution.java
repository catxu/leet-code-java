package com.catxu.leetcode.question235;

import com.catxu.leetcode.question.TreeNode;

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 利用bst性质，如果p/q小于当前节点，搜索左子树
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}
