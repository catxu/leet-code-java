package com.catxu.leetcode.question106;

import com.catxu.leetcode.question.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 * <p>
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.
 * <p>
 * Example 1:
 * <img src="./tree.png" alt="tree image" />
 * <p>
 * Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * Output: [3,9,20,null,null,15,7]
 * <p>
 * Example 2:
 * <p>
 * Input: inorder = [-1], postorder = [-1]
 * Output: [-1]
 * <p>
 * Constraints:
 * <p>
 * · 1 <= inorder.length <= 3000
 * <p>
 * · postorder.length == inorder.length
 * <p>
 * · -3000 <= inorder[i], postorder[i] <= 3000
 * <p>
 * · inorder and postorder consist of unique values.
 * <p>
 * · Each value of postorder also appears in inorder.
 * <p>
 * · inorder is guaranteed to be the inorder traversal of the tree.
 * <p>
 * · postorder is guaranteed to be the postorder traversal of the tree.
 */
class Solution {
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderIndexMap = new HashMap<>();

        // 将中序遍历的值和索引存入哈希表，便于快速查找根节点位置
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return buildSubTree(postorder, 0, postorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildSubTree(int[] postorder, int postStart, int postEnd, int inStart, int inEnd) {
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }

        // 从 后序遍历的起始位置获取根节点
        int rootValue = postorder[postEnd];
        TreeNode root = new TreeNode(rootValue);

        // 获取根节点在中序遍历中的索引位置
        int inRootIndex = inorderIndexMap.get(rootValue);

        // 计算左子树节点数 中序遍历根节点左边的元素即为左子树的所有节点
        int leftTreeSize = inRootIndex - inStart;
        System.out.printf("Constructing node %d | postStart: %d, postEnd: %d, inStart: %d, inEnd: %d%n", rootValue, postStart, postEnd, inStart, inEnd);

        // 递归构建左子树
        root.left = buildSubTree(postorder, postStart, postStart + leftTreeSize - 1, inStart, inRootIndex - 1);

        // 递归构建右子树
        root.right = buildSubTree(postorder, postStart + leftTreeSize, postEnd - 1, inRootIndex + 1, inEnd);

        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};  // 中序遍历数组
        int[] postorder = {9, 15, 7, 20, 3}; // 后序遍历数组

        Solution s = new Solution();
        TreeNode root = s.buildTree(inorder, postorder);

        // 打印树结构
        TreeNode.printTree(root);
    }
}