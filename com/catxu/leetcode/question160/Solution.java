package com.catxu.leetcode.question160;

import com.catxu.leetcode.question.ListNode;

/**
 * 160. Intersection of Two Linked Lists
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while (a != b) {
            a = a != null ? a.next : headB;
            b = b != null ? b.next : headA;
        }
        return a;
    }
}