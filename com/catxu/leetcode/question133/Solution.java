package com.catxu.leetcode.question133;

import java.util.*;

/**
 * 133. Clone Graph
 */
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        map.put(node, new Node(node.val, new ArrayList<>()));
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node neighbor : cur.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.offer(neighbor);
                }
                map.get(cur).neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }

    Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraphOptimized(Node node) {
        // DFS time: O(V + E)

        if (node == null) return null;
        // if the node was already visited before
        // return the clone from the visited map
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        // create a clone for the given node
        // note that we do not have cloned neighbors as of now, hence[]
        Node clone = new Node(node.val, new ArrayList<>());
        // the key is the original node and value is the clone node
        visited.put(node, clone);
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }
        return clone;

        // BFS
        // if (node == null) return node;
        // visited = new HashMap<>();
        // Queue<Node> q = new LinkedList<>();
        // q.add(node);
        // visited.put(node, new Node(node.val, new ArrayList<Node>()));
        // while (!q.isEmpty()) {
        //     int size = q.size();
        //     for (int i = 0; i < size; i++) {
        //         Node curr = q.remove();
        //         for (Node neighbor: curr.neighbors) {
        //             if (!visited.containsKey(neighbor)) {
        //                 visited.put(neighbor, new Node(neighbor.val, new ArrayList<Node>()));
        //                 q.add(neighbor);
        //             }
        //             visited.get(curr).neighbors.add(visited.get(neighbor));
        //         }
        //     }
        // }
        // return visited.get(node);

    }


    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
