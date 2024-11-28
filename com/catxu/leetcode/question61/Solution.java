package com.catxu.leetcode.question61;

import com.catxu.leetcode.question.ListNode;

/**
 * 61. Rotate List
 * <p>
 * Given the head of a linked list, rotate the list to the right by k places.
 * <p>
 * Example 1:
 * <p>
 *
 * <img src="./rotate1.png" alt="rotate list" />
 * <p>
 * Input: head = [1,2,3,4,5], k = 2
 * <p>
 * Output: [4,5,1,2,3]
 * <p>
 * Example 2:
 * <p>
 * <img src="./rotate2.png" alt="rotate list" />
 * <p>
 * Input: head = [0,1,2], k = 4
 * <p>
 * Output: [2,0,1]
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is in the range [0, 500].
 * <p>
 * -100 <= Node.val <= 100
 * <p>
 * 0 <= k <= 2 * 10<sup>9</sup>
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode cur = head;
        int length = 0;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        k = k % length;
        if (k == 0) {
            return head;
        }
        ListNode newTail = head;
        // length - k + 1 即为 newHead
        for (int i = 1; i < length - k; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        // 与 newHead 断开连接
        newTail.next = null;

        // 从 newHead 出发，将 原尾部 next 节点与原 head 相连
        ListNode oldTail = newHead;
        while (oldTail.next != null) {
            oldTail = oldTail.next;
        }
        oldTail.next = head;

        return newHead;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.rotateRight(ListNode.build(new int[]{1,2,3,4,5}), 2));
        System.out.println(s.rotateRight(ListNode.build(new int[]{0,1,2}), 4));
    }
}
