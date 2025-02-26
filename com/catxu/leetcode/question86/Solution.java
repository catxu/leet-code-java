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

        ListNode prevSmall = null;
        ListNode firstLarge = null;
        ListNode prevLarge = null;
        while (cur != null) {
            if (prevSmall == null && cur.val < x) {
                prevSmall = cur;
            } else if (firstLarge == null) {
                firstLarge = cur;
                prevLarge = cur;
            }

            if (cur.val < x && firstLarge != null) {
                ListNode next = cur.next;
                prevLarge.next = next;
                if (prevSmall != cur) {
                    prevSmall.next = cur;
                }
                cur.next = firstLarge;
                // small 向前移动一个
                prevSmall = prevSmall.next;
                cur = next;
                continue;
            } else {
                prevLarge = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    /*public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0, head);
        ListNode prevSmall = dummy; // 初始化 prevSmall 指向 dummy 节点
        ListNode firstLarge = null;
        ListNode prevLarge = dummy; // 初始化 prevLarge 指向 dummy 节点，便于处理 large 分区起始

        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                if (firstLarge != null) { // 如果已经存在 large 分区
                    ListNode next = cur.next;
                    prevLarge.next = next; // 将 cur 节点从 large 分区移除

                    prevSmall.next = cur;   // 将 cur 节点添加到 small 分区末尾
                    cur.next = firstLarge;  // 将 cur 节点的 next 指针指向 firstLarge，连接 small 和 large 分区
                    prevSmall = cur;        // 更新 prevSmall 指针到新的 small 分区末尾
                    cur = next;             // 继续遍历剩余节点
                    continue;
                } else { // 尚未出现 large 分区，说明当前节点及之前的节点都属于 small 分区
                    prevSmall = cur; // prevSmall 指针正常向后移动
                }
            } else { // cur.val >= x，当前节点属于 large 分区
                if (firstLarge == null) { // 首次遇到 large 分区节点
                    firstLarge = cur; // 标记 large 分区的起始节点
                }
                prevLarge = cur; // prevLarge 指针始终指向当前 large 分区的最后一个节点
            }
            cur = cur.next; // 移动到下一个节点
        }
        return dummy.next;
    }*/

    public static void main(String[] args) {
        System.out.println(new Solution().partition(ListNode.build(new int[]{1, 4, 3, 2, 5, 2}), 3));
        System.out.println(new Solution().partition(ListNode.build(new int[]{1, 4, 3, 2, 2, 5}), 5));
        System.out.println(new Solution().partition(ListNode.build(new int[]{2, 1}), 2));
    }
}
