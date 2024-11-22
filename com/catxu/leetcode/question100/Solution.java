package com.catxu.leetcode.question100;

import com.catxu.leetcode.question.TreeNode;

/**
 * 100. Same Tree
 * <p>
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * <p>
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 * <p>
 * Example 1:
 * <img src="./ex1.png" alt="tree image" />
 * <p>
 * Input: p = [1,2,3], q = [1,2,3]
 * <p>
 * Output: true
 * <p>
 * Example 2:
 * <img src="./ex2.png" alt="tree image" />
 * <p>
 * Input: p = [1,2], q = [1,null,2]
 * <p>
 * Output: false
 * <p>
 * Example 3:
 * <img src="./ex3.png" alt="tree image" />
 * <p>
 * Input: p = [1,2,1], q = [1,1,2]
 * <p>
 * Output: false
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in both trees is in the range [0, 100].
 * <p>
 * -10<sup>4</sup> <= Node.val <= 10<sup>4</sup>
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        // 一个 node 为空 或者 val 不相同的情况
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode p1 = TreeNode.levelOrderBuildTree(new Integer[]{1, 2, 3});
        TreeNode q1 = TreeNode.levelOrderBuildTree(new Integer[]{1, 2, 3});
        Solution s = new Solution();
        System.out.println(s.isSameTree(p1, q1));
        TreeNode p2 = TreeNode.levelOrderBuildTree(new Integer[]{1, 2});
        TreeNode q2 = TreeNode.levelOrderBuildTree(new Integer[]{1, null, 2});
        System.out.println(s.isSameTree(p2, q2));
        TreeNode p3 = TreeNode.levelOrderBuildTree(new Integer[]{1, 2, 1});
        TreeNode q3 = TreeNode.levelOrderBuildTree(new Integer[]{1, 1, 2});
        System.out.println(s.isSameTree(p3, q3));
        TreeNode p4 = TreeNode.levelOrderBuildTree(new Integer[]{});
        TreeNode q4 = TreeNode.levelOrderBuildTree(new Integer[]{});
        System.out.println(s.isSameTree(p4, q4));
    }
}
