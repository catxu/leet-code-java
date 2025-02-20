package com.catxu.leetcode.question82;

import com.catxu.leetcode.question.ListNode;

/**
 * 82. Remove Duplicates from Sorted List II
 * <p>
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
 * <p>
 * Example 1:
 * <pre>
 * Input: head = [1,2,3,3,4,4,5]
 * Output: [1,2,5]
 * </pre>
 * Example 2:
 * <pre>
 * Input: head = [1,1,1,2,3]
 * Output: [2,3]
 * </pre>
 * <p>
 * Constraints:
 * <pre>
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 * </pre>
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode prev = null;
        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy;
        while (cur != null) {
            if (prev != null && prev.val != cur.val) {
                pointer.next = new ListNode(prev.val);
                pointer = pointer.next;
            }
            while (prev != null && cur != null && prev.val == cur.val) {
                cur = cur.next;
            }
            if (cur == null) {
                return dummy.next;
            }
            prev = cur;
            cur = cur.next;
        }
        pointer.next = prev;
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().deleteDuplicates(ListNode.build(new int[]{1, 2, 3, 3, 4, 4, 5})));
        System.out.println(new Solution().deleteDuplicates(ListNode.build(new int[]{1, 1, 1, 2, 3})));
    }
}
