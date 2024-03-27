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

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(val);
        while (next != null) {
            str.append(next.val);
            next = next.next;
        }
        return str.toString();
    }
}
