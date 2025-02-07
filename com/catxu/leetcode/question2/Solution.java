package com.catxu.leetcode.question2;

import com.catxu.leetcode.question.ListNode;

/**
 * 2. Add Two Numbers
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example 1:
 * <pre>
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * </pre>
 * Example 2:
 * <pre>
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * </pre>
 * Example 3:
 * <pre>
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 * </pre>
 * Constraints:
 * <pre>
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 * </pre>
 * Definition for singly-linked list.
 * <pre>
 * {@code
 *  public class ListNode {
 *      int val;
 *      ListNode next;
 *      ListNode() {}
 *      ListNode(int val) { this.val = val; }
 *      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 *  }
 * }
 * </pre>
 */
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addTwoNumbers(ListNode.build(new int[]{2, 4, 3}), ListNode.build(new int[]{5, 6, 4})));
        System.out.println(solution.addTwoNumbers(ListNode.build(new int[]{0}), ListNode.build(new int[]{0})));
        System.out.println(solution.addTwoNumbers(ListNode.build(new int[]{9, 9, 9, 9, 9, 9, 9}), ListNode.build(new int[]{9, 9, 9, 9})));
    }

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
            val -= 10;
        }
        ListNode result = new ListNode(val);

        if ((l1 == null || l1.next == null) && (l2 == null || l2.next == null)) {
            return result;
        }

        result.next = addTwoNumbers(l1 == null ? null : l1.next, l2 == null ? null : l2.next);
        return result;
    }

}


