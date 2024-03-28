package com.catxu.leetcode.question;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode build(int[] vals) {
        ListNode dummy = new ListNode(0, new ListNode());
        ListNode cur = dummy.next;
        for (int i = 0; i < vals.length; i++) {
            cur.val = vals[i];
            cur.next = i != vals.length - 1 ? new ListNode() : null;
            cur = cur.next;
        }
        return dummy.next;
    }

    @Override
    public String toString() {
        ListNode dummy = new ListNode(0, this);
        StringBuilder sb = new StringBuilder();
        while (dummy.next != null) {
            sb.append(dummy.next.val);
            if (dummy.next.next != null) {
                sb.append("->");
            }
            dummy.next = dummy.next.next;
        }
        return sb.toString();
    }
}
