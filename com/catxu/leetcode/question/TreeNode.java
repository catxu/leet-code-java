package com.catxu.leetcode.question;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    void preOrder(TreeNode root, List<Integer> nodes) {
        if (root == null) {
            return;
        }
        nodes.add(root.val);
        preOrder(root.left, nodes);
        preOrder(root.right, nodes);
    }

    void inOrder(TreeNode root, List<Integer> nodes) {
        if (root == null) {
            return;
        }
        inOrder(root.left, nodes);
        nodes.add(root.val);
        inOrder(root.right, nodes);
    }

    void postOrder(TreeNode root, List<Integer> nodes) {
        if (root == null) {
            return;
        }
        postOrder(root.left, nodes);
        postOrder(root.right, nodes);
        nodes.add(root.val);
    }

    public TreeNode levelOrderBuildTree(Integer[] arr) {
        if (arr == null || arr.length == 0) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (i < arr.length) {
            TreeNode current = queue.poll();

            if (arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("The tree is empty.");
            return;
        }

        // 用于存放当前层的所有节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int level = 0; // 层级计数
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            System.out.print("Level " + level + ": ");

            // 遍历当前层的所有节点
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();

                if (current != null) {
                    System.out.print(current.val + " ");
                    queue.offer(current.left);
                    queue.offer(current.right);
                } else {
                    System.out.print("null ");
                }
            }
            System.out.println();
            level++;
        }
    }
}
