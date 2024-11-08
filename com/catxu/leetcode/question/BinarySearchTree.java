//package com.catxu.leetcode.question;
//
//public class BinarySearchTree {
//    TreeNode search(int num) {
//        TreeNode cur = root;
//        // 循环查找，越过叶节点后跳出
//        while (cur != null) {
//            // 目标节点在cur 的右子树中
//            if (cur.val < num)
//                cur = cur.right;
//                // 目标节点在cur 的左子树中
//            else if (cur.val > num)
//                cur = cur.left;
//                // 找到目标节点，跳出循环
//            else
//                break;
//        }
//        // 返回目标节点
//        return cur;
//    }
//
//    void insert(int num) {
//        // 若树为空，则初始化根节点
//        if (root == null) {
//            root = new TreeNode(num);
//            return;
//        }
//        TreeNode cur = root, pre = null;
//        // 循环查找，越过叶节点后跳出
//        while (cur != null) {
//            // 找到重复节点，直接返回
//            if (cur.val == num)
//                return;
//            pre = cur;
//            // 插入位置在cur 的右子树中
//            if (cur.val < num)
//                cur = cur.right;
//                // 插入位置在cur 的左子树中
//            else
//                cur = cur.left;
//        }
//        // 插入节点
//        TreeNode node = new TreeNode(num);
//        if (pre.val < num)
//            pre.right = node;
//        else
//            pre.left = node;
//    }
//
//    void remove(int num) {
//        // 若树为空，直接提前返回
//        if (root == null)
//            return;
//        TreeNode cur = root, pre = null;
//        // 循环查找，越过叶节点后跳出
//        while (cur != null) {
//            // 找到待删除节点，跳出循环
//            if (cur.val == num)
//                break;
//            pre = cur;
//            // 待删除节点在cur 的右子树中
//            if (cur.val < num)
//                cur = cur.right;
//                // 待删除节点在cur 的左子树中
//            else
//                cur = cur.left;
//        }
//        // 若无待删除节点，则直接返回
//        if (cur == null)
//            return;
//        // 子节点数量= 0 or 1
//        if (cur.left == null || cur.right == null) {
//            // 当子节点数量= 0 / 1 时， child = null / 该子节点
//            TreeNode child = cur.left != null ? cur.left : cur.right;
//            // 删除节点cur
//            if (cur != root) {
//                if (pre.left == cur)
//                    pre.left = child;
//                else
//                    pre.right = child;
//            } else {
//                // 若删除节点为根节点，则重新指定根节点
//                root = child;
//            }
//        }
//        // 子节点数量= 2
//        else {
//            // 获取中序遍历中cur 的下一个节点
//            TreeNode tmp = cur.right;
//            while (tmp.left != null) {
//                tmp = tmp.left;
//            }
//            // 递归删除节点tmp
//            remove(tmp.val);
//            // 用tmp 覆盖cur
//            cur.val = tmp.val;
//        }
//    }
//}
