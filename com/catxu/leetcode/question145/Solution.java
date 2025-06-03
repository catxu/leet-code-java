package com.catxu.leetcode.question145;

import com.catxu.leetcode.question.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 145. Binary Tree Postorder Traversal
 */
class Solution {
    class Node {
        TreeNode node;
        int color;

        Node(TreeNode node, int color) {
            this.node = node;
            this.color = color;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Deque<Node> stack = new LinkedList<>();
        if (root == null) return ans;
        stack.push(new Node(root, 1));
        // 颜色标记法遍历：使用颜色标记节点的状态，新节点为白色1，已访问的节点为灰色2
        // 如果遇到的节点为白色，则将其标记为灰色，然后根据遍历要求（前中后序）将其自身、右子节点、左子节点依次入栈
        // 后序遍历 左右根（因为是栈LIFO，所以要调整为 根右左）
        // 如果遇到的节点为灰色，则将节点的值输出
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            if (cur.node == null) continue;
            if (cur.color == 1) {
                stack.push(new Node(cur.node, 2)); // 根
                stack.push(new Node(cur.node.right, 1)); // 右
                stack.push(new Node(cur.node.left, 1)); // 左
            } else {
                ans.add(cur.node.val);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().postorderTraversal(TreeNode.levelOrderBuildTree(new Integer[]{1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9})));
    }
}
