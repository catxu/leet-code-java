package com.catxu.leetcode.question92;

import com.catxu.leetcode.question.ListNode;

import java.util.Stack;

/**
 * 92. Reverse Linked List II
 */
class Solution {
//    public ListNode reverseBetween(ListNode head, int left, int right) {
//        ListNode dummy = new ListNode(0, head);
//        ListNode cur = dummy.next, prev = cur;
//        int count = 1;
//        while (cur != null) {
//            if (count == left) {
//                ListNode reverseNode = cur;
//                Stack<ListNode> stack = new Stack<>();
//                stack.push(reverseNode);
//                while (count != right) {
//                    reverseNode = reverseNode.next;
//                    stack.push(reverseNode);
//                    count++;
//                }
//
//                ListNode node = stack.pop();
//                ListNode nextStart = node.next;
//                prev.next = node;
//                node.next = null;
//                cur = node;
//                while (!stack.isEmpty()) {
//                    ListNode n = stack.pop();
//                    n.next = null;
//                    cur.next = n;
//                    cur = cur.next;
//                }
//                cur.next = nextStart;
//                return dummy.next;
//            }
//            prev = cur;
//            cur = cur.next;
//            count++;
//        }
//        return head;
//    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        // 第 1 步：从虚拟头节点走 left - 1 步，来到 left 节点的前一个节点
        // 建议写在 for 循环里，语义清晰
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        // 第 2 步：从 pre 再走 right - left + 1 步，来到 right 节点
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        // 第 3 步：切断出一个子链表（截取链表）
        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;

        // 注意：切断链接
        pre.next = null;
        rightNode.next = null;

        // 第 4 步：同第 206 题，反转链表的子区间
        reverseLinkedList(leftNode);

        // 第 5 步：接回到原来的链表中
        pre.next = rightNode;
        leftNode.next = curr;
        return dummy.next;
    }

    private void reverseLinkedList(ListNode head) {
        // 也可以使用递归反转一个链表
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseBetween(ListNode.build(new int[]{1, 2, 3, 4, 5}), 2, 4));
        System.out.println(new Solution().reverseBetween(ListNode.build(new int[]{3, 5}), 1, 2));
    }
}
