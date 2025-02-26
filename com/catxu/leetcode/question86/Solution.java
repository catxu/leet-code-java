package com.catxu.leetcode.question86;

import com.catxu.leetcode.question.ListNode;

/**
 * 86. Partition List
 * <p>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 */
class Solution {

    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = head;

        // prevSmall -> firstLarge -> prevLarge -> cur -> next
        ListNode prevSmall = dummy;
        ListNode firstLarge = null;
        ListNode prevLarge = dummy;
        while (cur != null) {
            if (cur.val < x) {
                if (firstLarge != null) {
                    ListNode next = cur.next;
                    prevLarge.next = next;
                    prevSmall.next = cur;
                    cur.next = firstLarge;
                    // small 向前移动一个
                    prevSmall = prevSmall.next;
                    cur = next;
                    continue;
                } else {
                    prevSmall = cur;
                }
            } else {
                if (firstLarge == null) {
                    firstLarge = cur;
                }
                prevLarge = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().partition(ListNode.build(new int[]{1, 4, 3, 2, 5, 2}), 3));
        System.out.println(new Solution().partition(ListNode.build(new int[]{1, 4, 3, 7, 2, 5}), 6));
        System.out.println(new Solution().partition(ListNode.build(new int[]{2, 1}), 2));
    }
}
