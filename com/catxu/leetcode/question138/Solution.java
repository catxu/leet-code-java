package com.catxu.leetcode.question138;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 138. Copy List with Random Pointer
 * <p>
 * A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.
 * <p>
 * Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.
 * <p>
 * For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.
 * <p>
 * Return the head of the copied linked list.
 * <p>
 * The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
 * <pre>
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
 * Your code will only be given the head of the original linked list.
 * </pre>
 * Example 1:
 * <p>
 * <img src="./img.png" />
 * <pre>
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * </pre>
 * Example 2:
 * <p>
 * <img src="./img_1.png" />
 * <pre>
 * Input: head = [[1,1],[2,1]]
 * Output: [[1,1],[2,1]]
 * </pre>
 * Example 3:
 * <p>
 * <img src="./img_2.png" />
 * <pre>
 * Input: head = [[3,null],[3,0],[3,null]]
 * Output: [[3,null],[3,0],[3,null]]
 * </pre>
 * Constraints:
 * <pre>
 * 0 <= n <= 1000
 * -10<sup>4</sup> <= Node.val <= 10<sup>4</sup>
 * Node.random is null or is pointing to some node in the linked list.
 * </pre>
 */

class Solution {
    // Definition for a Node.
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // Step 1: Create a new node after each node in the original list.
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next; // Move to the next original node
        }

        // Step 2: Set the random pointer for the copied nodes.
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next; // Point to the copied node
            }
            curr = curr.next.next; // Move to the next original node
        }

        // Step 3: Separate the original and copied list.
        Node dummy = new Node(0);
        Node copyHead = dummy;
        curr = head;
        while (curr != null) {
            Node copy = curr.next;
            copyHead.next = copy;
            copyHead = copy;

            curr.next = copy.next; // Restore the next pointer of the original list
            curr = curr.next; // Move to the next original node
        }

        return dummy.next;
    }

//    public Node copyRandomList(Node head) {
//        Node dummy = new Node(0);
//        dummy.next = head;
//        Node cur = dummy.next;
//        Queue<Node> queue = new LinkedList<>();
//        while (cur != null) {
//            Node node = new Node(cur.val);
//            if (cur.random != null) {
//                node.random = new Node(cur.random.val);
//            }
//
//            queue.offer(node);
//            cur = cur.next;
//        }
//        Node newHead = new Node(0);
//        cur = newHead;
//        while (!queue.isEmpty()) {
//            cur.next = queue.poll();
//            cur = cur.next;
//        }
//        return newHead.next;
//    }
}
