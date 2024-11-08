package com.catxu.leetcode.question105;

import com.catxu.leetcode.question.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * <p>
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 * <p>
 * Example 1:
 * <img src="./tree.jpg" alt="tree image" />
 * <p>
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * <p>
 * Example 2:
 * <p>
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 * <p>
 * Constraints:
 * <p>
 * · 1 <= preorder.length <= 3000
 * <p>
 * · inorder.length == preorder.length
 * <p>
 * · -3000 <= preorder[i], inorder[i] <= 3000
 * <p>
 * · preorder and inorder consist of unique values.
 * <p>
 * · Each value of inorder also appears in preorder.
 * <p>
 * · preorder is guaranteed to be the preorder traversal of the tree.
 * <p>
 * · inorder is guaranteed to be the inorder traversal of the tree.
 */
class Solution {
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIndexMap = new HashMap<>();

        // 将中序遍历的值和索引存入哈希表，便于快速查找根节点位置
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return buildSubTree(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildSubTree(int[] preorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // 从前序遍历的起始位置获取根节点
        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);

        // 获取根节点在中序遍历中的索引位置
        int inRootIndex = inorderIndexMap.get(rootValue);

        // 计算左子树节点数 中序遍历根节点左边的元素即为左子树的所有节点
        int leftTreeSize = inRootIndex - inStart;

        // 递归构建左子树
        root.left = buildSubTree(preorder, preStart + 1, preStart + leftTreeSize, inStart, inRootIndex - 1);

        // 递归构建右子树
        root.right = buildSubTree(preorder, preStart + leftTreeSize + 1, preEnd, inRootIndex + 1, inEnd);

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7}; // 前序遍历数组
        int[] inorder = {9, 3, 15, 20, 7};  // 中序遍历数组

        Solution s = new Solution();
        TreeNode root = s.buildTree(preorder, inorder);

        // 打印树结构
        TreeNode.printTree(root);
    }
}