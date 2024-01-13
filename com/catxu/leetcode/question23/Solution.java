package com.catxu.leetcode.question23;

import com.catxu.leetcode.question.ListNode;

import java.util.*;

/**
 * 23. Merge k Sorted Lists
 * <p>
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * <p>
 * Merge all the linked-lists into one sorted linked-list and return it.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 * Example 2:
 * <p>
 * Input: lists = []
 * Output: []
 * Example 3:
 * <p>
 * Input: lists = [[]]
 * Output: []
 * <p>
 * <p>
 * Constraints:
 * <p>
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] is sorted in ascending order.
 * The sum of lists[i].length will not exceed 10^4.
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        Queue<ListNode> stack = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode list : lists) {
            if (list != null) {
                stack.add(list);
            }
        }
        ListNode cur = dummy;
        while (!stack.isEmpty()) {
            ListNode min = stack.poll();
            cur.next = min;
            if (min.next != null) {
                stack.add(min.next);
            }
            cur = cur.next;
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
        solution.mergeKLists(new ListNode[]{node1_0, node2_0});
    }
}
