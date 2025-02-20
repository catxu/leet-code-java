package com.catxu.leetcode.question206;

import com.catxu.leetcode.question.ListNode;

/**
 * 206. Reverse Linked List
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseList(ListNode.build(new int[]{1, 2, 3, 4, 5})));
        System.out.println(new Solution().reverseList(ListNode.build(new int[]{1, 2})));
        System.out.println(new Solution().reverseList(null));
    }
}
