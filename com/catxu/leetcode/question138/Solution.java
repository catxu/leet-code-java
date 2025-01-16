package com.catxu.leetcode.question138;

import java.util.HashMap;
import java.util.Map;

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

    Map<Node, Node> copyedNodeMap = new HashMap<>();

//    public Node copyRandomList(Node head) {
//        if (head == null) {
//            return null;
//        }
//        if (!copyedNodeMap.containsKey(head)) {
//            Node newNode = new Node(head.val);
//            copyedNodeMap.put(head, newNode);
//            newNode.next = copyRandomList(head.next);
//            newNode.random = copyRandomList(head.random);
//        }
//        return copyedNodeMap.get(head);
//    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> targetMap = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            targetMap.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            Node node = targetMap.get(cur);
            node.next = targetMap.get(cur.next);
            node.random = targetMap.get(cur.random);
            cur = cur.next;
        }
        return targetMap.get(head);
    }

    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node2.random = node1;
        node4.random = node3;
        node5.random = node1;

        System.out.println(new Solution().copyRandomList(node1));
    }
}
