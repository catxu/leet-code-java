package com.catxu.leetcode.question297;

import com.catxu.leetcode.question.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 297. Serialize and Deserialize Binary Tree
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) return sb.toString();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int n = q.size(); // 当前layer的节点数量
            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                if (node == null) {
                    sb.append('#').append(',');
                } else {
                    sb.append(node.val).append(",");
                    q.offer(node.left);
                    q.offer(node.right);
                }
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] nodes = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        q.offer(root);
        int n = nodes.length;
        int i = 1;
        while (i < n) {
            TreeNode cur = q.poll(); // 思考：反序列化时为什么不需要知道子树节点范围
            if (!"#".equals(nodes[i])) {
                cur.left = new TreeNode(Integer.parseInt(nodes[i]));
                q.offer(cur.left);
            }
            i++;
            if (i < n && !"#".equals(nodes[i])) {
                cur.right = new TreeNode(Integer.parseInt(nodes[i]));
                q.offer(cur.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = TreeNode.levelOrderBuildTree(new Integer[]{1, 2, 3, null, null, 4, null, null, 5});
        String treeStr = codec.serialize(root);
        System.out.println(treeStr);
        TreeNode.printTree(codec.deserialize(treeStr));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
