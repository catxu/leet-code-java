package com.catxu.leetcode.question2;

/**
 * 2. Add Two Numbers
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example 1:
 * <p>
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * <p>
 * Output: [7,0,8]
 * <p>
 * Explanation: 342 + 465 = 807.
 * <p>
 * Example 2:
 * <p>
 * Input: l1 = [0], l2 = [0]
 * <p>
 * Output: [0]
 * <p>
 * Example 3:
 * <p>
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * <p>
 * Output: [8,9,9,9,0,0,0,1]
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in each linked list is in the range [1, 100].
 * <p>
 * 0 <= Node.val <= 9
 * <p>
 * It is guaranteed that the list represents a number that does not have leading zeros.
 * <p>
 * * Definition for singly-linked list.
 * * public class ListNode {
 * *     int val;
 * *     ListNode next;
 * *     ListNode() {}
 * *     ListNode(int val) { this.val = val; }
 * *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
        if (val >= 10) {
            if (l1 == null) {
                // 两数相加不会超过20
                l1 = new ListNode(1);
            } else {
                if (l1.next == null) {
                    l1.next = new ListNode(1);
                } else {
                    l1.next.val = l1.next.val + 1;
                }
            }
            val = val - 10;
        }
        ListNode result = new ListNode(val);

        if ((l1 == null || l1.next == null) && (l2 == null || l2.next == null)) {
            return result;
        }

        result.next = addTwoNumbers(l1 == null ? null : l1.next, l2 == null ? null : l2.next);
        return result;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}


