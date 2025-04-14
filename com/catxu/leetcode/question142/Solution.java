package com.catxu.leetcode.question142;

import com.catxu.leetcode.question.ListNode;

/**
 * 142. Linked List Cycle II
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head, meetingNode = null; // 标准Floyd算法，slow和fast都从head出发
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                meetingNode = fast;
                break;
            }
        }
        if (meetingNode == null) {
            return null;
        }
        return cycleEntrance(head, meetingNode);
    }

    private ListNode cycleEntrance(ListNode head, ListNode meetingNode) {
        while (head != meetingNode) {
            head = head.next;
            meetingNode = meetingNode.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode root1 = ListNode.build(new int[]{3, 2, 0, -4});
        root1.next.next.next.next = root1.next;
        System.out.println(new Solution().detectCycle(root1).val);
    }
}
