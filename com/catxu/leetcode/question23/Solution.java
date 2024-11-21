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
 * Example 1:
 * <p>
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * <p>
 * Output: [1,1,2,3,4,4,5,6]
 * <p>
 * Explanation: The linked-lists are:
 * <p>
 * [
 * <p>
 * 1->4->5,
 * <p>
 * 1->3->4,
 * <p>
 * 2->6
 * <p>
 * ]
 * <p>
 * merging them into one sorted list:
 * <p>
 * 1->1->2->3->4->4->5->6
 * <p>
 * Example 2:
 * <p>
 * Input: lists = []
 * <p>
 * Output: []
 * <p>
 * Example 3:
 * <p>
 * Input: lists = [[]]
 * <p>
 * Output: []
 * <p>
 * Constraints:
 * <p>
 * k == lists.length
 * <p>
 * 0 <= k <= 10<sup>4</sup>
 * <p>
 * 0 <= lists[i].length <= 500
 * <p>
 * -10<sup>4</sup> <= lists[i][j] <= 10<sup>4</sup>
 * <p>
 * lists[i] is sorted in ascending order.
 * <p>
 * The sum of lists[i].length will not exceed 10<sup>4</sup>.
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
        // [1,4,5],[1,3,4],[2,6]
        ListNode node1_0 = ListNode.build(new int[]{1, 4, 5});
        ListNode node1_1 = ListNode.build(new int[]{1, 3, 4});
        ListNode node1_2 = ListNode.build(new int[]{2, 6});
        System.out.println(solution.mergeKLists(new ListNode[]{node1_0, node1_1, node1_2}));
    }
}
