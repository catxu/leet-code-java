package com.catxu.leetcode.question82;

import com.catxu.leetcode.question.ListNode;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy.next;
        Queue<ListNode> queue = new LinkedList<>();
        queue.offer(cur);
        cur = cur.next;
        while (cur != null) {
            ListNode prev = queue.poll();
            if (prev.val == cur.val) {
                prev.next = cur.next;
                queue.offer(prev);
            } else {
                queue.offer(cur);
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.deleteDuplicates(ListNode.build(new int[]{1, 1, 2})));
        System.out.println(s.deleteDuplicates(ListNode.build(new int[]{1, 1, 2, 3, 3})));
        System.out.println(s.deleteDuplicates(ListNode.build(new int[]{1, 1, 1})));
    }

    /* 更优解
     *
     * public ListNode deleteDuplicates(ListNode head) {
     *         if(head == null){
     *             return head;
     *         }
     *         ListNode cur =head;
     *         while (cur.next != null){
     *            if(cur.val == cur.next.val){
     *             cur.next =cur.next.next;
     *            }else{
     *             cur = cur.next;
     *            }
     *         }
     *         return head;
     *     }
     */
}

