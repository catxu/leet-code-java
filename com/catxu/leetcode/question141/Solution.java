package com.catxu.leetcode.question141;

import com.catxu.leetcode.question.ListNode;

/**
 * 141. Linked List Cycle
 * <p>
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * <p>
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 * <p>
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 * <p>
 * Example 1:
 * <p>
 * <img src="./circularlinkedlist.png" />
 * <p>
 * Input: head = [3,2,0,-4], pos = 1
 * <p>
 * Output: true
 * <p>
 * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
 * <p>
 * Example 2:
 * <p>
 * <img src="./circularlinkedlist_test2.png" />
 * <p>
 * Input: head = [1,2], pos = 0
 * <p>
 * Output: true
 * <p>
 * Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
 * <p>
 * Example 3:
 * <p>
 * <img src="./circularlinkedlist_test3.png" />
 * <p>
 * Input: head = [1], pos = -1
 * <p>
 * Output: false
 * <p>
 * Explanation: There is no cycle in the linked list.
 * <p>
 * Constraints:
 * <p>
 * The number of the nodes in the list is in the range [0, 10<sup>4</sup>].
 * <p>
 * -10<sup>5</sup> <= Node.val <= 10<sup>5</sup>
 * <p>
 * pos is -1 or a valid index in the linked-list.
 * <p>
 * Follow up: Can you solve it using O(1) (i.e. constant) memory?
 */
class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast != slow) {
            ListNode next = fast.next;
            if (next != null) {
                fast = next.next;
            } else {
                return false;
            }
            slow = slow.next;
        }
        return fast == slow;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode root1 = ListNode.build(new int[]{3, 2, 0, -4});
        root1.next.next.next.next = root1.next;
        System.out.println(s.hasCycle(root1));
        ListNode root2 = ListNode.build(new int[]{1, 2});
        root2.next = root2;
        System.out.println(s.hasCycle(root2));
        ListNode root3 = ListNode.build(new int[]{1});
        System.out.println(s.hasCycle(root3));
        ListNode root4 = ListNode.build(new int[]{1, 1});
        System.out.println(s.hasCycle(root4));
        ListNode root5 = ListNode.build(new int[]{});
        System.out.println(s.hasCycle(root5));
    }
}
