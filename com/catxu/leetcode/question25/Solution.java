package com.catxu.leetcode.question25;

import com.catxu.leetcode.question.ListNode;

/**
 * 25. Reverse Nodes in k-Group
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        while (head != null) {
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return dummy.next;
                }
            }
            ListNode next = tail.next;
            ListNode[] nodes = reverseBetween(head, tail);
            head = nodes[0];
            tail = nodes[1];
            // 链接原链表
            pre.next = head;
            tail.next = next;
            pre = tail;
            head = tail.next;
        }
        return dummy.next;
    }

    private ListNode[] reverseBetween(ListNode head, ListNode tail) {
        ListNode pre = tail.next, cur = head;
        while (pre != tail) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return new ListNode[]{tail, head};
    }


    public static void main(String[] args) {
        System.out.println(new Solution().reverseKGroup(ListNode.build(new int[]{1, 2, 3, 4, 5}), 2));
        System.out.println(new Solution().reverseKGroup(ListNode.build(new int[]{1, 2, 3, 4, 5}), 3));
    }
}
