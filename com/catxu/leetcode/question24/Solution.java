package com.catxu.leetcode.question24;

import com.catxu.leetcode.question.ListNode;

/**
 * 24. Swap Nodes in Pairs
 * <p>
 * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 * <p>
 * Example 1:
 * <p>
 * Input: head = [1,2,3,4]
 * <p>
 * Output: [2,1,4,3]
 * <p>
 * Example 2:
 * <p>
 * Input: head = []
 * <p>
 * Output: []
 * <p>
 * Example 3:
 * <p>
 * Input: head = [1]
 * <p>
 * Output: [1]
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is in the range [0, 100].
 * <p>
 * 0 <= Node.val <= 100
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode first = head;
        ListNode second = head.next;
        ListNode suffix = swapPairs(second.next);
        first.next = suffix;
        second.next = first;
        return second;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode listNode = ListNode.build(new int[]{1, 2, 3, 4});
        System.out.println(s.swapPairs(listNode));
    }
}
