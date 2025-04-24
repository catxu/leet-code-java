package com.catxu.leetcode.question725;

import com.catxu.leetcode.question.ListNode;

/**
 * 725. Split Linked List in Parts
 */
public class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int cnt = 0;
        ListNode t = head;
        while (t != null) {
            cnt++;
            t = t.next;
        }
        int unit = cnt / k, remain = cnt % k; // 每个part长度 和 均分后多出来的remain
        ListNode[] ans = new ListNode[k];
        for (int i = 0; i < k; i++) {
            ListNode cur = head;
            ans[i] = cur;
            cnt = unit + (remain-- > 0 ? 1 : 0); // 每个part长度 + 均摊长度
            while (cnt-- > 1 && cur != null) cur = cur.next;

            if (cur == null) {
                head = null;
            } else {
                head = cur.next;
                cur.next = null;
            }
        }
        return ans;
    }
}
