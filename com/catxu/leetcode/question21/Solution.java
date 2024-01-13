package com.catxu.leetcode.question21;

/**
 * 21. Merge Two Sorted Lists
 * <p>
 * You are given the heads of two sorted linked lists list1 and list2.
 * <p>
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Return the head of the merged linked list.
 * <p>
 * <p>
 * <p>
 * Example 1:Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * <p>
 * Example 2:
 * <p>
 * Input: list1 = [], list2 = []
 * Output: []
 * <p>
 * Example 3:
 * <p>
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        if (cur1 == null) {
            cur.next = cur2;
        } else {
            cur.next = cur1;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node1_2 = new ListNode(4);
        ListNode node1_1 = new ListNode(2, node1_2);
        ListNode node1_0 = new ListNode(1, node1_1);
        ListNode node2_2 = new ListNode(4);
        ListNode node2_1 = new ListNode(3, node2_2);
        ListNode node2_0 = new ListNode(1, node2_1);
        solution.mergeTwoLists(node1_0, node2_0);
        ListNode case2_1 = null;
        ListNode case2_2 = null;
        solution.mergeTwoLists(case2_1, case2_2);
        ListNode case3_1 = null;
        ListNode case3_2 = new ListNode(0);
        solution.mergeTwoLists(case3_1, case3_2);
        System.out.println();
    }


    public static class ListNode {
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
