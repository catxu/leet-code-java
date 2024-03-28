package com.catxu.leetcode.question19;

import com.catxu.leetcode.question.ListNode;

/**
 * 19. Remove Nth Node From End of List
 * <p>
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * <p>
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * <p>
 * Example 2:
 * <p>
 * Input: head = [1], n = 1
 * Output: []
 * <p>
 * Example 3:
 * <p>
 * Input: head = [1,2], n = 1
 * Output: [1]
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * <p>
 * Follow up: Could you do this in one pass?
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int traverse = traverse(head, n);
        if (traverse == n)
            return head.next;
        return head;
    }

    private int traverse(ListNode node, int n) {
        if (node == null)
            return 0;
        int num = traverse(node.next, n);
        if (num == n)
            node.next = node.next.next;
        return num + 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.removeNthFromEnd(ListNode.build(new int[]{1, 2, 3, 4, 5}), 2));
        System.out.println(s.removeNthFromEnd(ListNode.build(new int[]{1}), 1));
        System.out.println(s.removeNthFromEnd(ListNode.build(new int[]{1, 2}), 1));
    }
}